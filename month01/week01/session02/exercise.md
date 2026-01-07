<!-- exercise 1 -->
1. mkdir git-review && cd git-review 
2. git init 
3. echo "#Git Review Project"> README.md
4. git status
5. git add .
6. git commit -m "test3"
7. git log 
<!-- exercise 2 -->
1. cat >index.html <<'EOF'
2. git add index.html 
3. cat > style.css << 'EOF'
4. git add style.css 
5. git log --oneline
<!-- exercise 3 -->
1. git branch
2. git switch -c feature-about
3. git cat >about.html << 'EOF'
4. git add about.html 
git commit -m "feat: Add about page"
5. git branch
<!-- exercise 4 -->
1. git switch main 
2. ls 
3. git switch feature-about
4. ls 
5. git log --oneline --all --graph 
<!-- exercise 3.1 -->
1. git switch main
2. git merge feature-about
<!-- exercise 3.4-->
1. git switch main 
2. cat > index.html << 'EOF'
git add index.html
git commit -m "Update heading in main"
3. git switch -c feature-conflict
4. cat > index.html << 'EOF'
 git add index.html
 git commit -m "Update heading in feature"
5. git switch main
git merge feature-conflict
6. Conflict шийдвэрлэх
# index.html файлыг editor-оор нээж,
# Хоёр өөрчлөлтийг нэгтгэх эсвэл аль нэгийг нь сонгох
7. git add index.html
$ git commit -m "Merge feature-conflict, keep both messages"




