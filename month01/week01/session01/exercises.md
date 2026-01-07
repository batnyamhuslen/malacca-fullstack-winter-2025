<!--exercise 01-->
1. git config --global user.name "khuslen"
2. git config --global user.email"your@email.com"
3. git config --global init.defaultBranch main 
4. git config -- list
<!-- exercise 02-->
1. mkdir git practice 
cd git-practice
2. git init 
3. git status 
4. ls -la
<!-- exercise 03 -->
1. echo "Git Practice"> README.md 
2. git status
3. git add . 
4. git status
5. git commit -m "test1" 
6. git log 
<!-- exercise 04 -->
1. touch index.html style.css script.js
2. git add .
3. git status 
4. git commit -m " asd    "
<!-- exercise 5 -->
1. cat > .gitignore << 'EOF'
node_modules/
.env
*.log
EO
2. mkdir node_modules
   touch .env
   touch error.log
3. git status 
4. git add .
git commit -m "add .gitingore"
<!-- exercise 6 -->
1. cat > index.html 'EOF'
 EOF
2. git diff 
3. git add index.html
 git diff --stat
 4. git commit -m "add html structure"
<!-- exercise 7 -->
1. git log
2. git log --oneline
3. git log -n 2
4. git log --index.html 
<!-- exercise 8  -->
1. ssh keygen -t ed25519 -c"      "
2. eval "$(ssh-agent -s)"
3. ssh-add ~/.ssh/
4. cat ~/.ssh/id_ed25519. 
<!-- exercise 9 -->
1. 