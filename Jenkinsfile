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
                bat "mvn clean package"
            }
        }
        
        stage('Build Docker Image')
        {
            steps
            {
                script
                {
                    bat 'docker build -t sandeepchatuphale/test';
                }
            }
        }
 
    }
}
