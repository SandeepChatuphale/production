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
        
        
         stage('Pushing Docker Image')
        {
            steps
            {
                script
                {
                    withCredentials([string(credentialsId: 'sandeepchatuphale', variable: 'dockerhub')]) 
                    {
                        bat "docker login -u sandeepchatuphale -p ${dockerhub}"
                        bat 'docker push sandeepchatuphale/test'
                   }
                }
            }
            
            
         stage('Running Docker Image on QA Server')
        {
            steps
            {
                script
                {
                    withCredentials([string(credentialsId: 'sandeepchatuphale', variable: 'dockerhub')]) 
                    {
                        bat "docker login -u sandeepchatuphale -p ${dockerhub}"
                        bat 'docker push sandeepchatuphale/test'
                   }
                }
            }
        }
        
        

    }

}
