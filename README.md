# Explanation and Example for Pipeline Libraries and Shared Libraries
Note: hands on lab will be provided on the next slides

1. **Configuring Shared Libraries in Jenkins**
To use shared libraries in Jenkins, you need to configure them in your Jenkins instance and then reference them in your pipelines.
Global Steps to Configure Shared Libraries:
One need to Create a Git Repository for the Shared Library:
The repository should have a specific structure with a vars directory for global variables and a src directory for Groovy classes.
Add the Shared Library in Jenkins:
Go to Jenkins Dashboard > Manage Jenkins > System.
Scroll down to the Global Pipeline Libraries section.
Add a new library:
Name: Give it a name (e.g., my-shared-library).
Default version: Specify a branch or tag.
Retrieval method: Choose Modern SCM and select Git.
Project Repository: Provide the repository URL.
2. Using Shared Libraries in a Jenkins Pipeline
Once the shared library is configured, you can load and use it in your Jenkinsfile.
Example:
```java
@Library('my-shared-library') _

pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    // Call a shared library function
                    myLibrary.buildApp()
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    // Use another function from the shared library
                    myLibrary.deployApp(env.BRANCH_NAME)
                }
            }
        }
    }

    post {
        always {
            script {
                // Call a cleanup function from the shared library
                myLibrary.cleanup()
            }
        }
    }
}
```

Explanation:
@Library('my-shared-library') _: This line loads the shared library named my-shared-library for use in the pipeline.
Calling Shared Library Functions: Functions defined in the shared library can be called directly in the pipeline using their defined names (e.g., myLibrary.buildApp()).
3. Structuring Shared Libraries
To effectively use shared libraries, organize them as follows:
vars Directory:
Contains global variable scripts (.groovy files) that can be used directly in pipelines.
Example: myLibrary.groovy with functions like buildApp(), deployApp(), etc.
src Directory:
Contains Groovy classes for more complex logic or object-oriented programming.
Use Java-style packaging for classes (e.g., com.company.lib).
```
my-shared-library/
├── vars/
└── src/
```

4. Best Practices for Using Shared Libraries
Version Control: Use version control for shared libraries. Specify versions or branches to ensure pipelines use the correct library version.
Documentation: Document shared library functions and classes clearly to help users understand how to use them.
Modularize Code: Break down shared library code into smaller, reusable functions to promote modularity and reuse.
Testing: Write tests for shared library functions to ensure reliability and ease of maintenance.
Summary:
Pipeline Libraries and Shared Libraries in Jenkins provide a powerful way to reuse code and standardize CI/CD processes.
Configuring and using shared libraries allows for modular, maintainable, and DRY pipelines.
Follow best practices to ensure shared libraries are robust, well-documented, and easy to use across different teams and projects.
By integrating shared libraries, Jenkins pipelines become more flexible, maintainable, and consistent, enhancing the overall CI/CD workflow.

