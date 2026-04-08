const gameboard = document.querySelector("#gameboard");
const playerDisplay = document.querySelector("#player-turn");

const pieces = {
    'r': 'https://upload.wikimedia.org/wikipedia/commons/f/ff/Chess_rdt45.svg',
    'n': 'https://upload.wikimedia.org/wikipedia/commons/e/ef/Chess_ndt45.svg',
    'b': 'https://upload.wikimedia.org/wikipedia/commons/9/98/Chess_bdt45.svg',
    'q': 'https://upload.wikimedia.org/wikipedia/commons/4/47/Chess_qdt45.svg',
    'k': 'https://upload.wikimedia.org/wikipedia/commons/f/f0/Chess_kdt45.svg',
    'p': 'https://upload.wikimedia.org/wikipedia/commons/c/c7/Chess_pdt45.svg',
    'R': 'https://upload.wikimedia.org/wikipedia/commons/7/72/Chess_rlt45.svg',
    'N': 'https://upload.wikimedia.org/wikipedia/commons/7/70/Chess_nlt45.svg',
    'B': 'https://upload.wikimedia.org/wikipedia/commons/b/b1/Chess_blt45.svg',
    'Q': 'https://upload.wikimedia.org/wikipedia/commons/1/15/Chess_qlt45.svg',
    'K': 'https://upload.wikimedia.org/wikipedia/commons/4/42/Chess_klt45.svg',
    'P': 'https://upload.wikimedia.org/wikipedia/commons/4/45/Chess_plt45.svg'
};

const boardLayout = [
    'r','n','b','q','k','b','n','r',
    'p','p','p','p','p','p','p','p',
    '','','','','','','','',
    '','','','','','','','',
    '','','','','','','','',
    '','','','','','','','',
    'P','P','P','P','P','P','P','P',
    'R','N','B','Q','K','B','N','R'
];

let turn = 'white';

function createBoard() {
    boardLayout.forEach((pieceCode, i) => {
        const square = document.createElement('div');
        square.classList.add('square');
        const row = Math.floor(i / 8);
        square.classList.add((row + i) % 2 === 0 ? 'beige' : 'brown');
        square.setAttribute('square-id', i);

        if (pieceCode !== '') {
            const pieceImg = document.createElement('img');
            pieceImg.src = pieces[pieceCode];
            pieceImg.classList.add('piece');
            pieceImg.setAttribute('draggable', true);
            pieceImg.setAttribute('data-type', pieceCode);
            square.appendChild(pieceImg);
        }
        gameboard.append(square);
    });
}

createBoard();

let draggedPiece;
let startId;

gameboard.addEventListener('dragstart', (e) => {
    const isWhitePiece = e.target.getAttribute('data-type') === e.target.getAttribute('data-type').toUpperCase();
    if ((turn === 'white' && !isWhitePiece) || (turn === 'black' && isWhitePiece)) {
        e.preventDefault();
        return;
    }
    draggedPiece = e.target;
    startId = parseInt(e.target.parentNode.getAttribute('square-id'));
});

gameboard.addEventListener('dragover', e => e.preventDefault());

gameboard.addEventListener('drop', (e) => {
    e.preventDefault();
    let targetSquare = e.target.classList.contains('square') ? e.target : e.target.parentNode;
    const targetId = parseInt(targetSquare.getAttribute('square-id'));
    const pieceType = draggedPiece.getAttribute('data-type');

    if (isValidMove(pieceType, startId, targetId, targetSquare)) {
        // Move piece
        if (targetSquare.firstChild) targetSquare.removeChild(targetSquare.firstChild);
        targetSquare.appendChild(draggedPiece);
        
        // Switch Turn
        turn = turn === 'white' ? 'black' : 'white';
        playerDisplay.innerText = turn.charAt(0).toUpperCase() + turn.slice(1) + "'s Turn";
    }
});

function isValidMove(piece, start, target, targetSquare) {
    const row = Math.floor(start / 8);
    const col = start % 8;
    const tRow = Math.floor(target / 8);
    const tCol = target % 8;
    const rowDiff = tRow - row;
    const colDiff = tCol - col;

    // Prevent taking your own pieces
    if (targetSquare.firstChild) {
        const isTargetWhite = targetSquare.firstChild.getAttribute('data-type') === targetSquare.firstChild.getAttribute('data-type').toUpperCase();
        if ((turn === 'white' && isTargetWhite) || (turn === 'black' && !isTargetWhite)) return false;
    }

    switch (piece.toLowerCase()) {
        case 'p': // Pawn
            const dir = piece === 'P' ? -1 : 1;
            // Standard move
            if (colDiff === 0 && !targetSquare.firstChild) {
                if (rowDiff === dir) return true;
                if (rowDiff === 2 * dir && ((piece === 'P' && row === 6) || (piece === 'p' && row === 1))) return true;
            }
            // Capture
            if (Math.abs(colDiff) === 1 && rowDiff === dir && targetSquare.firstChild) return true;
            return false;

        case 'r': // Rook
            if (row !== tRow && col !== tCol) return false;
            return true; // Simplified (needs collision check)

        case 'n': // Knight
            return (Math.abs(rowDiff) === 2 && Math.abs(colDiff) === 1) || (Math.abs(rowDiff) === 1 && Math.abs(colDiff) === 2);

        case 'b': // Bishop
            return Math.abs(rowDiff) === Math.abs(colDiff);

        case 'q': // Queen
            return Math.abs(rowDiff) === Math.abs(colDiff) || row === tRow || col === tCol;

        case 'k': // King
            return Math.abs(rowDiff) <= 1 && Math.abs(colDiff) <= 1;

        default: return false;
    }
}
// 1. Find the King's position
function findKing(color) {
    const kingType = color === 'white' ? 'K' : 'k';
    const allSquares = document.querySelectorAll('.square');
    for (let i = 0; i < allSquares.length; i++) {
        if (allSquares[i].firstChild?.getAttribute('data-type') === kingType) {
            return i;
        }
    }
    return null;
}

// 2. Check if a specific square is under attack
function isSquareAttacked(targetId, attackerColor) {
    const allSquares = document.querySelectorAll('.square');
    for (let i = 0; i < allSquares.length; i++) {
        const piece = allSquares[i].firstChild;
        if (piece) {
            const type = piece.getAttribute('data-type');
            const isWhite = type === type.toUpperCase();
            const pieceColor = isWhite ? 'white' : 'black';

            if (pieceColor === attackerColor) {
                // Check if this piece could legally move to the targetId
                if (isValidMove(type, i, targetId, allSquares[targetId], true)) {
                    return true;
                }
            }
        }
    }
    return false;
}

// 3. The "Checkmate" Check
function isCheckmate(color) {
    const kingPos = findKing(color);
    const enemyColor = color === 'white' ? 'black' : 'white';

    // If king isn't even in check, it's not checkmate
    if (!isSquareAttacked(kingPos, enemyColor)) return false;

    // To be truly realistic, you must loop through every piece of 'color'
    // and see if ANY move they make removes the check.
    // For now, we'll alert "Check!"
    return true; 
}
gameboard.addEventListener('drop', (e) => {
    e.preventDefault();
    let targetSquare = e.target.classList.contains('square') ? e.target : e.target.parentNode;
    const targetId = parseInt(targetSquare.getAttribute('square-id'));
    const pieceType = draggedPiece.getAttribute('data-type');

    if (isValidMove(pieceType, startId, targetId, targetSquare)) {
        const originalContent = targetSquare.innerHTML;
        
        // Execute move
        targetSquare.innerHTML = '';
        targetSquare.appendChild(draggedPiece);
        
        // Verify if move puts YOUR OWN king in check (Illegal move)
        const myColor = turn;
        if (isSquareAttacked(findKing(myColor), myColor === 'white' ? 'black' : 'white')) {
            // Undo move
            sourceSquare.appendChild(draggedPiece);
            targetSquare.innerHTML = originalContent;
            alert("Invalid: You cannot leave your King in check!");
            return;
        }

        // Check for Check/Checkmate on opponent
        const opponentColor = turn === 'white' ? 'black' : 'white';
        if (isSquareAttacked(findKing(opponentColor), turn)) {
            playerDisplay.innerText = "CHECK!";
            playerDisplay.style.color = "red";
        } else {
            playerDisplay.style.color = "white";
        }

        turn = opponentColor;
        // ... rest of turn logic
    }
});