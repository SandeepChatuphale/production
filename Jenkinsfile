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
                    bat 'docker build -t sandeepchatuphale/test .'
                }
            }
        }
    }

}
