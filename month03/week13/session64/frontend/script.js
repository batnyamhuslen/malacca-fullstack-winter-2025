const MOVES = {
    fire_blast: { name: 'FIRE BLAST', power: 45, type: 'attack', anim: 'animate__shakeX' },
    slash: { name: 'SLASH', power: 25, type: 'attack', anim: 'animate__bounce' },
    recover: { name: 'RECOVER', power: -60, type: 'heal', anim: 'animate__heartBeat' }, // Negative damage = Heal
    toxic: { name: 'TOXIC', power: 20, type: 'attack', anim: 'animate__flash' }
};

class GameEngine {
    constructor() {
        this.max_hp = 250;
        this.p_hp = 250;
        this.e_hp = 250;
        this.isBusy = false;
        this.init();
    }

    init() {
        document.querySelectorAll('.move-btn').forEach(btn => {
            btn.onclick = (e) => this.playerAction(e.target.dataset.move);
        });
        this.typeMessage("A wild MEWTWO blocks your path!");
    }

    async typeMessage(text) {
        const el = document.getElementById('typewriter-text');
        el.innerText = "";
        for (const char of text) {
            el.innerText += char;
            await new Promise(r => setTimeout(r, 25));
        }
    }

    // Fixed: Prevents HP from exceeding max or dropping below zero
    updateStats(target, amount) {
        if (target === 'player') {
            this.p_hp = Math.min(this.max_hp, Math.max(0, this.p_hp - amount));
            const fill = document.getElementById('player-hp');
            fill.style.width = `${(this.p_hp / this.max_hp) * 100}%`;
            document.getElementById('p-hp-cur').innerText = this.p_hp;
            this.setBarColor(fill, (this.p_hp / this.max_hp) * 100);
        } else {
            this.e_hp = Math.min(this.max_hp, Math.max(0, this.e_hp - amount));
            const fill = document.getElementById('enemy-hp');
            fill.style.width = `${(this.e_hp / this.max_hp) * 100}%`;
            this.setBarColor(fill, (this.e_hp / this.max_hp) * 100);
        }
    }

    setBarColor(el, percent) {
        if (percent < 20) el.style.background = "#ff4757";
        else if (percent < 50) el.style.background = "#ffa502";
        else el.style.background = "#2ed573";
    }

    async playerAction(moveKey) {
        if (this.isBusy || this.p_hp <= 0 || this.e_hp <= 0) return;
        this.isBusy = true;
        
        const move = MOVES[moveKey];
        await this.typeMessage(`CHARIZARD used ${move.name}!`);
        
        this.applyEffect('enemy', move);
        await new Promise(r => setTimeout(r, 1200));

        if (this.e_hp <= 0) {
            await this.typeMessage("Enemy MEWTWO fainted! Victory!");
            this.showResetButton();
        } else {
            this.enemyAction();
        }
    }

    async enemyAction() {
        const move = MOVES.toxic; // Enemy AI move
        await this.typeMessage("MEWTWO used PSYSTRIKE!");
        
        this.applyEffect('player', move);
        await new Promise(r => setTimeout(r, 1200));

        if (this.p_hp <= 0) {
            await this.typeMessage("CHARIZARD fainted... You lost.");
            this.showResetButton();
        } else {
            this.isBusy = false;
            await this.typeMessage("What will CHARIZARD do?");
        }
    }

    applyEffect(target, move) {
        const isEnemyTarget = target === 'enemy';
        const sprite = document.getElementById(isEnemyTarget ? 'enemy-sprite' : 'player-sprite');
        const screen = document.getElementById('game-master');

        // Apply health change
        this.updateStats(target === 'enemy' ? 'enemy' : 'player', move.power);

        // Visual Feedback
        if (move.power > 0) screen.classList.add('shake');
        sprite.classList.add('animate__animated', move.anim);
        
        setTimeout(() => {
            screen.classList.remove('shake');
            sprite.classList.remove('animate__animated', move.anim);
        }, 600);
    }

    showResetButton() {
        const menu = document.getElementById('menu');
        menu.innerHTML = `<button class="move-btn" style="grid-column: span 2" onclick="location.reload()">REMATCH</button>`;
    }
}

new GameEngine();