# Cloud Run Hello World Application

This application is used to explore various basic features of Cloud Run for Spring Boot.

The application is based on the [Cloud Run Quickstart: Build and Deploy tutorial](https://cloud.google.com/run/docs/quickstarts/build-and-deploy).

Cloud Build was replaced with [Jib](https://github.com/GoogleContainerTools/jib/tree/master/jib-maven-plugin#quickstart) to make iteration faster.


1. Build and push the image to Container Registry.
    ````
    $ GOOGLE_CLOUD_PROJECT=your-google-cloud-project
    
    $ mvn compile -Dimage=gcr.io/${GOOGLE_CLOUD_PROJECT}/helloworld jib:build
    ````

1. Deploy to Cloud Run.
    ````
    $ gcloud run deploy helloworld --image gcr.io/${GOOGLE_CLOUD_PROJECT}/helloworld --platform managed --region us-east1
    ````

1. Route traffic to the latest revision.
    ````
   $ gcloud alpha run services update-traffic helloworld --platform managed --region us-east1 --to-latest
   ````

1. Run the app and view logs in Cloud Console.
http://console.cloud.google.com/run/detail/us-east1/helloworld/revisions
