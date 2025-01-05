## Git Commands

### To start any new project
    > First you need to go GitHub Ui & create Remote repository with project name
	
	> After creating Remote repo you need to create Local repo aswell
    git init "repo_name"            ( To create new local repository with project name)
	
	> After creating local repo you need to link with Remote repo(Https/SSH)
	git remote add origin "Https/SSH link"
	
    > After creating Repo, if you add Readme.md file in Ui you need pull those changes 
	git pull origin main --rebase   ( To pull initial changes in GitHub UI)
	
	> Then you start working with Git

### To clone the existing repository in GitHub repository.
    git clone "https URL "

### After change the name of repository in GitHub UI you need to update the URL connection with local to Remote(GitHub UI).
    git remote -v                                   ( to check the current URL of Local to Remote)
    git remote set-url origin "Https/SSH link"      ( to update the new URL of Local to Remote)
    git pull origin main                            ( to pull the changes in GitHub UI)
	
### To add new or modified file into staging area.
    git add "file_name"             ( for new/modified)
    git add .                       ( for modified in current branch)
    git add *                       ( for modified in all branchs)

### To unstage the file in Local repository.
    git rm --cached "file_name"     ( for unstage the file )

### To check any untracked file in Local repository?
    git status   

### To commit the changes in Local repository.
    git commit -m "commit message"           ( before commit you need to stage the changes)
    git commit -a -m "commit message"        ( when you use "-a" you no need to stage the changes before commit )

### To push the changes to GitHub repository from Local repository.
    git push origin "sourceBranch" 

### To check/verify the modified content in the existing file.
    git diff "file_name"

### After creating new branch in Local you need push this entire branch to GitHub repository.
    git checkout "new_branch"
    git push -u origin "new_branch"			( for first time you need use this push new branch)

### After creating new branch in GitHub UI you need fetch the entire branch to Local repository.
    git fetch origin                ( to dispaly  the all brachs)
    git branch -r                   ( to list the all brachs in GitHub server)
    git checkout "new_branch"       ( to change the new brach then new brach will refelect in Local)

### After Modify the file in GitHub UI you need Pull the changes to Local repository.
    git checkout "Modifed_branch"           ( first you need checkout to modified file branch)
    git pull origin "Modifed_branch"        ( then you can pull the changes you made in the GitHub UI)

### After delete branch in GitHub UI you need fetch those changes to Local repository.
    git fetch --prune               ( it will display latest info from GitHub Ui including branch deletes)
    git branch -a                   ( it will list all your local and GitHub branches)
    git branch -d "branch-name"     ( you need to delete the branch explicitly in local)

### After delete branch in local you need push those changes to GitHub repository.
    git branch -d "branch-name"                 ( to delete a branch in local)
    git push origin --delete "branch-name"      ( to push the branch deletion changes to GitHub)
    git branch -r                               ( it will list all GitHub branches)

### After delete a file in GitHub UI you need Pull the changes to Local repository.
    git checkout "deleted_file_branch"           ( first you need checkout to deleted file branch)
    git fetch                                    ( it will display latest info from GitHub Ui including file deletes)
    git pull origin "deleted_file_branch"        ( then you can pull the changes you made in the GitHub UI)

### After delete a file in Local you need Push the changes to GitHub repository.
    git rm "file_name"                           ( to remove the file in local)
    git commit -m "Delete file-name"             ( to commit the file deletion in local)
    git push origin "deleted_file_branch"        ( then you can push the changes you made in the Local)
