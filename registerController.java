package sample.controller;
//package sample.javamail;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

import static javafx.fxml.FXMLLoader.load;
import static javax.mail.Transport.send;
import static sample.controller.email_sender.send_to;

public class registerController {
    @FXML
    TextField tf1, tf2, tf3;
    @FXML
    DatePicker d;
    @FXML
    Button btn;

    private Stage stage;
    private Scene scene;
    private Parent parent;

    public void switchToLogin(ActionEvent event) throws IOException{
        Parent root = load(getClass().getResource("../view/login.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("../css/login.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

    public void switchTextField_1() throws IOException{
        tf1.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)){
                tf2.requestFocus();
                String s = tf1.getText();
                System.out.println(s);
                send_to(s);
            }
        });
    }

    public void switchTextField_2() throws IOException{
        tf2.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)){
                tf3.requestFocus();
            }
        });
    }

//    public void switchtodatepicker() throws IOException{
//        tf3.setOnKeyPressed(event -> {
//            if(event.getCode().equals(KeyCode.ENTER)){
//                d.requestFocus();
//                /*String s = textField1.getText();
//                System.out.println(s);*/
//            }
//        });
//    }
//
//    public void switchtobutton() throws IOException{
//        d.setOnKeyPressed(event -> {
//            if(event.getCode().equals(KeyCode.ENTER)){
//                btn.requestFocus();
//                /*String s = textField1.getText();
//                System.out.println(s);*/
//            }
//        });
//    }
}

class email_sender
{
  public  static  void send_to(String receiver)
  {
      System.out.println("sdfsd");

      Properties prop = new Properties();
//      prop.put("mail.smtp.host", "smtp.gmail.com");
      prop.put("mail.smtp.ssl.trust", "smtp.gmail.com"); //ssl.trust
      prop.put("mail.smtp.port", "587");
      prop.put("mail.smtp.auth", "true");
      prop.put("mail.smtp.starttls.enable", "true"); //TLS

//      Properties p = new Properties();
//      p.put("mail.smtp.host", "smtp.gmail.com");
//      p.put("mail.smtp.socketFactory.port", "465");
//      p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//      p.put("mail.smtp.auth", "true");
//      p.put("mail.smtp.port", "465");

//      String  d_email = "maverick.19333537@gmail.com",
//              d_uname = "Name",
//              d_password = "maverick4321",
//              d_host = "smtp.gmail.com",
//              d_port  = "465",
//              m_to = "toAddress@gmail.com",
////              m_subject = "Indoors Readable File: " + params[0].getName(),
//              m_text = "This message is from Indoor Positioning App. Required file(s) are attached.";
//      Properties props = new Properties();
//      props.put("mail.smtp.user", d_email);
//      props.put("mail.smtp.host", d_host);
//      props.put("mail.smtp.port", d_port);
//      props.put("mail.smtp.starttls.enable","true");
//      props.put("mail.smtp.debug", "true");
//      props.put("mail.smtp.auth", "true");
//      props.put("mail.smtp.socketFactory.port", d_port);
//      props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//      props.put("mail.smtp.socketFactory.fallback", "false");
      //get Session

      String sender = "maverick.19333537@gmail.com";
      String password = "maverick4321";

      Session session = Session.getDefaultInstance(prop,
              new javax.mail.Authenticator() {
                  protected PasswordAuthentication getPasswordAuthentication() {
                      return new PasswordAuthentication(sender, password);
                  }
              });

      int code = (int)(Math.random()*(999999-100000+1)+100000);
      String msg = Integer.toString(code);
      //compose message
//      try {
//          MimeMessage message = new MimeMessage(session);
//          message.addRecipient(Message.RecipientType.TO,new InternetAddress(receiver));
//          message.setSubject("The 6 digit verification code for your signup in Maverick");
//          message.setText(msg);
//          //send message
//          send(message);
//          System.out.println("message sent successfully");
//           }
      try {

          Message message = new MimeMessage(session);
          message.setFrom(new InternetAddress(sender));
          message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver));
          message.setSubject("Testing Gmail TLS");
          message.setText("Dear Mail Crawler,"
                  + "\n\n Please do not spam my email!");

          Transport.send(message); // Transport.send(msg);

          System.out.println("message sent successfully");
        }
      catch (MessagingException e) {  e.printStackTrace();}
  }
}

//         } catch (MessagingException mex) { mohtasim.hossain2000@gmail.com
//         mex.printStackTrace();















