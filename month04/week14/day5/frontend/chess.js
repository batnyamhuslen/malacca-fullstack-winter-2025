class ChessGame {
    constructor() {
        this.board = [];
        this.selectedSquare = null;
        this.currentPlayer = 'white';
        this.gameOver = false;
        this.gameResult = null;
        this.moveHistory = [];
        this.initializeBoard();
        this.render();
        this.setupEventListeners();
        this.checkGameStatus();
    }

    initializeBoard() {
        this.board = Array(8).fill(null).map(() => Array(8).fill(null));

        // Black pieces (top)
        this.board[0] = ['r', 'n', 'b', 'q', 'k', 'b', 'n', 'r'].map(p => ({ type: p, color: 'black' }));
        for (let i = 0; i < 8; i++) {
            this.board[1][i] = { type: 'p', color: 'black' };
        }

        // Empty squares
        for (let row = 2; row < 6; row++) {
            for (let col = 0; col < 8; col++) {
                this.board[row][col] = null;
            }
        }

        // White pieces (bottom)
        for (let i = 0; i < 8; i++) {
            this.board[6][i] = { type: 'p', color: 'white' };
        }
        this.board[7] = ['r', 'n', 'b', 'q', 'k', 'b', 'n', 'r'].map(p => ({ type: p, color: 'white' }));
    }

    getSymbol(piece) {
        const symbols = {
            'r': '♜', 'n': '♞', 'b': '♝', 'q': '♛', 'k': '♚', 'p': '♟',
            'R': '♖', 'N': '♘', 'B': '♗', 'Q': '♕', 'K': '♔', 'P': '♙'
        };
        return symbols[piece.type] || '';
    }

    isInBounds(row, col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }

    findKing(color) {
        for (let row = 0; row < 8; row++) {
            for (let col = 0; col < 8; col++) {
                const piece = this.board[row][col];
                if (piece && piece.type === 'k' && piece.color === color) {
                    return { row, col };
                }
            }
        }
        return null;
    }

    isSquareAttacked(row, col, byColor) {
        for (let r = 0; r < 8; r++) {
            for (let c = 0; c < 8; c++) {
                const piece = this.board[r][c];
                if (piece && piece.color === byColor) {
                    if (this.canPieceAttack(r, c, row, col)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    canPieceAttack(fromRow, fromCol, toRow, toCol) {
        const piece = this.board[fromRow][fromCol];
        if (!piece) return false;

        const moves = this.getAvailableMoves(fromRow, fromCol, false);
        return moves.some(m => m.row === toRow && m.col === toCol);
    }

    isInCheck(color) {
        const king = this.findKing(color);
        if (!king) return false;

        const enemyColor = color === 'white' ? 'black' : 'white';
        return this.isSquareAttacked(king.row, king.col, enemyColor);
    }

    wouldBeInCheck(fromRow, fromCol, toRow, toCol, color) {
        const boardCopy = this.board.map(row => [...row]);
        this.board[toRow][toCol] = this.board[fromRow][fromCol];
        this.board[fromRow][fromCol] = null;

        const inCheck = this.isInCheck(color);

        this.board = boardCopy;
        return inCheck;
    }

    getLegalMoves(row, col) {
        const piece = this.board[row][col];
        if (!piece || piece.color !== this.currentPlayer) return [];

        const availableMoves = this.getAvailableMoves(row, col, true);
        
        return availableMoves.filter(move => {
            return !this.wouldBeInCheck(row, col, move.row, move.col, piece.color);
        });
    }

    getAvailableMoves(row, col, checkLegality = true) {
        const piece = this.board[row][col];
        if (!piece) return [];

        const type = piece.type.toLowerCase();
        let moves = [];

        switch (type) {
            case 'p':
                moves = this.getPawnMoves(row, col, piece.color);
                break;
            case 'n':
                moves = this.getKnightMoves(row, col, piece.color);
                break;
            case 'b':
                moves = this.getBishopMoves(row, col, piece.color);
                break;
            case 'r':
                moves = this.getRookMoves(row, col, piece.color);
                break;
            case 'q':
                moves = this.getQueenMoves(row, col, piece.color);
                break;
            case 'k':
                moves = this.getKingMoves(row, col, piece.color);
                break;
        }

        return moves;
    }

    getPawnMoves(row, col, color) {
        const moves = [];
        const direction = color === 'white' ? -1 : 1;
        const startRow = color === 'white' ? 6 : 1;

        const nextRow = row + direction;
        if (this.isInBounds(nextRow, col) && !this.board[nextRow][col]) {
            moves.push({ row: nextRow, col });

            const twoAhead = row + 2 * direction;
            if (row === startRow && !this.board[twoAhead][col]) {
                moves.push({ row: twoAhead, col });
            }
        }

        for (const dc of [-1, 1]) {
            const captureRow = row + direction;
            const captureCol = col + dc;
            if (this.isInBounds(captureRow, captureCol)) {
                const target = this.board[captureRow][captureCol];
                if (target && target.color !== color) {
                    moves.push({ row: captureRow, col: captureCol });
                }
            }
        }

        return moves;
    }

    getKnightMoves(row, col, color) {
        const moves = [];
        const positions = [
            [-2, -1], [-2, 1], [-1, -2], [-1, 2],
            [1, -2], [1, 2], [2, -1], [2, 1]
        ];

        for (const [dr, dc] of positions) {
            const newRow = row + dr;
            const newCol = col + dc;
            if (this.isInBounds(newRow, newCol)) {
                const target = this.board[newRow][newCol];
                if (!target || target.color !== color) {
                    moves.push({ row: newRow, col: newCol });
                }
            }
        }
        return moves;
    }

    addMovesInDirection(moves, row, col, color, directions) {
        for (const [dr, dc] of directions) {
            let r = row + dr;
            let c = col + dc;
            while (this.isInBounds(r, c)) {
                if (!this.board[r][c]) {
                    moves.push({ row: r, col: c });
                } else {
                    if (this.board[r][c].color !== color) {
                        moves.push({ row: r, col: c });
                    }
                    break;
                }
                r += dr;
                c += dc;
            }
        }
    }

    getBishopMoves(row, col, color) {
        const moves = [];
        const directions = [[-1, -1], [-1, 1], [1, -1], [1, 1]];
        this.addMovesInDirection(moves, row, col, color, directions);
        return moves;
    }

    getRookMoves(row, col, color) {
        const moves = [];
        const directions = [[-1, 0], [1, 0], [0, -1], [0, 1]];
        this.addMovesInDirection(moves, row, col, color, directions);
        return moves;
    }

    getQueenMoves(row, col, color) {
        const moves = [];
        const directions = [
            [-1, -1], [-1, 0], [-1, 1],
            [0, -1], [0, 1],
            [1, -1], [1, 0], [1, 1]
        ];
        this.addMovesInDirection(moves, row, col, color, directions);
        return moves;
    }

    getKingMoves(row, col, color) {
        const moves = [];
        const directions = [
            [-1, -1], [-1, 0], [-1, 1],
            [0, -1], [0, 1],
            [1, -1], [1, 0], [1, 1]
        ];

        for (const [dr, dc] of directions) {
            const newRow = row + dr;
            const newCol = col + dc;
            if (this.isInBounds(newRow, newCol)) {
                const target = this.board[newRow][newCol];
                if (!target || target.color !== color) {
                    moves.push({ row: newRow, col: newCol });
                }
            }
        }
        return moves;
    }

    hasAnyLegalMove(color) {
        for (let row = 0; row < 8; row++) {
            for (let col = 0; col < 8; col++) {
                const piece = this.board[row][col];
                if (piece && piece.color === color) {
                    const legalMoves = this.getLegalMoves(row, col);
                    if (legalMoves.length > 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    checkGameStatus() {
        const inCheck = this.isInCheck(this.currentPlayer);
        const hasLegalMove = this.hasAnyLegalMove(this.currentPlayer);

        const statusLog = document.getElementById('statusLog');
        const gameStatus = document.getElementById('gameStatus');

        if (!hasLegalMove) {
            this.gameOver = true;
            if (inCheck) {
                this.gameResult = this.currentPlayer === 'white' ? 'Black Wins (Checkmate)!' : 'White Wins (Checkmate)!';
                gameStatus.textContent = this.gameResult;
                gameStatus.className = 'game-status checkmate';
                statusLog.textContent = `CHECKMATE!\n${this.gameResult}`;
            } else {
                this.gameResult = 'Stalemate - Draw!';
                gameStatus.textContent = this.gameResult;
                gameStatus.className = 'game-status stalemate';
                statusLog.textContent = `STALEMATE!\nThe game is a draw.`;
            }
        } else if (inCheck) {
            gameStatus.textContent = `${this.currentPlayer.toUpperCase()} in CHECK!`;
            gameStatus.className = 'game-status check';
            statusLog.textContent = `⚠️ ${this.currentPlayer.toUpperCase()} is in CHECK!`;
        } else {
            gameStatus.textContent = '';
            gameStatus.className = 'game-status';
            statusLog.textContent = `${this.currentPlayer.charAt(0).toUpperCase() + this.currentPlayer.slice(1)}'s turn to move.`;
        }
    }

    isValidMove(fromRow, fromCol, toRow, toCol) {
        const legalMoves = this.getLegalMoves(fromRow, fromCol);
        return legalMoves.some(m => m.row === toRow && m.col === toCol);
    }

    movePiece(fromRow, fromCol, toRow, toCol) {
        if (this.gameOver) {
            alert('Game is over! Click Reset to play again.');
            return false;
        }

        if (this.isValidMove(fromRow, fromCol, toRow, toCol)) {
            const piece = this.board[fromRow][fromCol];
            this.board[toRow][toCol] = piece;
            this.board[fromRow][fromCol] = null;

            this.moveHistory.push({
                from: { row: fromRow, col: fromCol },
                to: { row: toRow, col: toCol },
                piece: piece
            });

            this.currentPlayer = this.currentPlayer === 'white' ? 'black' : 'white';
            this.selectedSquare = null;
            this.render();
            this.checkGameStatus();
            return true;
        }
        return false;
    }

    render() {
        const boardElement = document.getElementById('chessBoard');
        boardElement.innerHTML = '';

        const kingPos = this.findKing(this.currentPlayer);
        const inCheck = this.isInCheck(this.currentPlayer);

        for (let row = 0; row < 8; row++) {
            for (let col = 0; col < 8; col++) {
                const square = document.createElement('div');
                const isWhiteSquare = (row + col) % 2 === 0;
                square.className = `square ${isWhiteSquare ? 'white' : 'black'}`;
                square.id = `square-${row}-${col}`;

                if (inCheck && kingPos && kingPos.row === row && kingPos.col === col) {
                    square.classList.add('check');
                }

                const piece = this.board[row][col];
                if (piece) {
                    const pieceSpan = document.createElement('span');
                    pieceSpan.className = `piece ${piece.color}-piece`;
                    pieceSpan.textContent = this.getSymbol(piece);
                    square.appendChild(pieceSpan);
                }

                square.addEventListener('click', () => this.handleSquareClick(row, col));
                boardElement.appendChild(square);
            }
        }

        this.updateHighlights();
        document.getElementById('currentTurn').textContent = 
            this.currentPlayer.charAt(0).toUpperCase() + this.currentPlayer.slice(1);
    }

    updateHighlights() {
        document.querySelectorAll('.square').forEach(sq => {
            if (!sq.classList.contains('check')) {
                sq.classList.remove('selected', 'available');
            }
        });

        if (this.selectedSquare) {
            const { row, col } = this.selectedSquare;
            document.getElementById(`square-${row}-${col}`).classList.add('selected');

            const moves = this.getLegalMoves(row, col);
            moves.forEach(move => {
                document.getElementById(`square-${move.row}-${move.col}`).classList.add('available');
            });
        }
    }

    handleSquareClick(row, col) {
        if (this.gameOver) return;

        if (this.selectedSquare) {
            if (this.selectedSquare.row === row && this.selectedSquare.col === col) {
                this.selectedSquare = null;
            } else if (this.movePiece(this.selectedSquare.row, this.selectedSquare.col, row, col)) {
                return;
            } else {
                const piece = this.board[row][col];
                if (piece && piece.color === this.currentPlayer) {
                    this.selectedSquare = { row, col };
                }
            }
        } else {
            const piece = this.board[row][col];
            if (piece && piece.color === this.currentPlayer) {
                this.selectedSquare = { row, col };
            }
        }
        this.render();
    }

    resetGame() {
        this.initializeBoard();
        this.selectedSquare = null;
        this.currentPlayer = 'white';
        this.gameOver = false;
        this.gameResult = null;
        this.moveHistory = [];
        this.render();
        this.checkGameStatus();
    }

    setupEventListeners() {
        document.getElementById('resetBtn').addEventListener('click', () => this.resetGame());
    }
}

window.addEventListener('DOMContentLoaded', () => {
    new ChessGame();
});