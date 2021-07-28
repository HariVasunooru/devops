job('First-Maven-Project-Via-DSL') {
    description("First Maven job generated by the DSL on ${new Date()}, the project is a small Maven project hosted on github")
    scm {
		git('git@gitlab.com:hari.vasunooru/devops.git','main')
    }
    triggers {
        scm('* * * * *')
    }
    steps {
        maven('clean package', 'java-tomcat-sample/pom.xml')
    }
    publishers {
        //archive the war file generated
        archiveArtifacts '**/*.jar'
    }
}