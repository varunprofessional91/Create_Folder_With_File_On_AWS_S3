import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
//import com.amazonaws.services.lambda.runtime.Context;
//import com.amazonaws.services.lambda.runtime.LambdaLogger;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Pack_Class {

    public static void main(String[] args) {

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd hhmmss");
        DateFormat dateFormat2 = new SimpleDateFormat("yyyyMMdd");

        String strDate = dateFormat.format(date);
        String strDate2 = dateFormat2.format(date);

        String accessKey = "AKIA3MNGU5RUHOBGDN4X";    // example accessKey
        String secretKey = "pC5v/4oPXraoDR43fd1tX8tQlyay8AAS8JJaKlqN";    // example secretKey
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        AmazonS3 s3 = new AmazonS3Client(credentials, new ClientConfiguration().withProtocol(Protocol.HTTP));
        String bucketName = "varunkumarr92/parentfolder/childfolder";    // example bucketName
        String key = strDate2 + "/" + strDate + ".txt";
        InputStream input = new ByteArrayInputStream(new byte[0]);
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(0);
        s3.putObject(new PutObjectRequest(bucketName, key, input, metadata));
        System.out.println("\nUploaded Successfully\n");
    }
}
