pipeline 
{
    agent any
    
    environment
    {
        M2_HOME = 'D:\\Softwares\\java\\maven3.6.0'
        PATH = "${M2_HOME}\\bin;${env.PATH}"
    }
 
    stages 
    {
        stage('Build') 
        {
            steps 
            {         
                // Get some code from a GitHub repository
                git 'https://github.com/SandeepChatuphale/production.git'
            }
        }
        
        stage('Package')
        {
            steps
            {
                bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }
        
         stage('Sonar')
        {
            steps
            {
                withSonarQubeEnv('mysonar')
                {
                    bat 'mvn sonar:sonar'
                }
            }
        }
 
    }
}
