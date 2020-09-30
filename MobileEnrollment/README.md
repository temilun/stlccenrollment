# STLCC Mobile Enrollment

This is a student group project where we are building a mobile class registration web application.

## Development environment
The project is being built with Netbeans 8.2 and JDK 8.

To run, simply download the project and ensure you have Netbeans 8.2 and JDK 8, then open the MobileEnrollment project folder. Note - you may have to update the mysql connector driver used in NetBeans. The version we used is available [HERE](https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-8.0.21.zip), download the zip and extract the jar file inside then replace the mysql connector driver that is used in the project.


## Git Workflow

### This project uses the [GitHub flow](https://guides.github.com/introduction/flow/) branching strategy.

Everyone develops their own feature branches off of the master branch and pushes back to master when their feature is complete, but the feature must be aprroved in a pull request.

#### [YouTube Example](https://www.youtube.com/watch?v=GgjIvUrOpmg) of this workflow

### How to put your feature on the master branch

1. Be sure you are currently on the master branch and your master branch is up to date.
```bash
git status    # tells you your current branch
git pull      # updates your master branch to the most recent version
```

2. Create a new feature branch off of the master branch and switch to that branch.
```bash
git branch feature-name   
git checkout feature-name
```

3. Make the changes your feature needs. When you reach a good stopping point, commit locally then push to your remote branch. Repeat this step as many times as needed until you finish your feature.
```bash
git add -A
git commit -m "Commit message"
git push      # `git push --set-upstream origin feature-name` on first push
```

4. When your feature is finally finished, Create a pull request to merge your branch into master.
* Go to the [repo](https://github.com/temilun/stlccenrollment) on GitHub
* Click on the [pull request](https://github.com/temilun/stlccenrollment/pulls) tab
* Click the [new pull request](https://github.com/temilun/stlccenrollment/compare) button
* Make `base` the master branch. Make `compare` the feature-name branch
* Click the `Create pull request` button
* Make a relevant title and comment for your pull request.
* Add all team members as Reviewers on the right hand side. I'm unsure if we need this one for all pull requests.
* Click `Create pull request`.
* After review, click the merge pull request button to merge into master.

5. Delete the newly merged feature-name branch
* On GitHub, click the `Delete Branch` button for the `feature-name` branch you just merged
* Go back to your local project directory, checkout master, pull new merge changes, and delete the old branch locally
```bash
git checkout master                         # we can't delete the old branch if we're still on it
git pull                                    # pull the updated master branch that now has feature-name's work
git branch --delete feature-name            # deletes local branch
git branch --delete -r origin/feature-name  # deletes the local tracking branch
```
