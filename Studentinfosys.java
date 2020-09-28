/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentinfosys;

import java.sql.*;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.*;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Studentinfosys extends Application {
    
    String subject,yr;
    @Override
    public void start(Stage primaryStage) {
        Label title =  new Label("STUDENT INFORMATION SYSTEM\n");
        title.setStyle("-fx-font-size:20px;");
        
        HBox box1 = new HBox();
        Label l1 = new Label("Dept. No: ");
        l1.setStyle("-fx-font-weight:bold;-fx-font-size:15px;");
        TextField deptno = new TextField();
        deptno.setMaxWidth(150);
        
        Label l2 = new Label("Name: ");
        l2.setStyle("-fx-font-weight:bold;-fx-font-size:15px;");
        TextField name = new TextField();
        name.setMaxWidth(150);
        
        box1.setSpacing(16);
        box1.getChildren().addAll(l1,deptno,l2,name);
        
        HBox box2 = new HBox();
        Label l3 = new Label("Year: ");
        l3.setStyle("-fx-font-weight:bold;-fx-font-size:15px;");
        String year_list[] = { "I", "II", "III","I PG", "II PG" }; 
        ComboBox yearbox = new ComboBox(FXCollections.observableArrayList(year_list)); 
        
        Label l5 = new Label("Shift: ");
        l5.setStyle("-fx-font-weight:bold;-fx-font-size:15px;");
        ToggleGroup rbtg = new ToggleGroup();
        RadioButton rb1 = new RadioButton("I");
        RadioButton rb2 = new RadioButton("II");
        rb1.setToggleGroup(rbtg);
        rb2.setToggleGroup(rbtg);
        
        box2.setSpacing(17);
        box2.getChildren().addAll(l3,yearbox,l5,rb1,rb2);
        
        
        VBox box3_1 = new VBox();
        Label l4 =  new Label("Subjects: ");
        l4.setStyle("-fx-font-weight:bold;-fx-font-size:15px;");
        ObservableList<String> subs = FXCollections.observableArrayList("Advanced Java", "OOPs", "Operating Systems", "Web Programming", "Visual Programming", "Data Structures", "DBMS","Software Engineering","Computer Concepts");
        ListView<String> subjs = new ListView<>(subs);
        subjs.setMaxSize(150,120);
        box3_1.getChildren().addAll(l4,subjs);
        
        VBox box3_2 = new VBox();
        Label l6 = new Label("Languages: ");
        l6.setStyle("-fx-font-weight:bold;-fx-font-size:15px;");
        CheckBox ck1 = new CheckBox("English");
        CheckBox ck2 = new CheckBox("Tamil");
        CheckBox ck3 = new CheckBox("Telugu");
        CheckBox ck4 = new CheckBox("Hindi");
        CheckBox ck5 = new CheckBox("Others");
        box3_2.setSpacing(6);
        box3_2.getChildren().addAll(l6,ck1,ck2,ck3,ck4,ck5);
        
        VBox box3_3 = new VBox();
        Label l7 = new Label("Marks: ");
        l7.setStyle("-fx-font-weight:bold;-fx-font-size:15px;");
        TextField m1 = new TextField();
        m1.setMaxWidth(90);
        m1.setPromptText("Mark 1");
        TextField m2 = new TextField();
        m2.setMaxWidth(90);
        m2.setPromptText("Mark 2");
        TextField m3 = new TextField();
        m3.setPromptText("Mark 3");
        m3.setMaxWidth(90);
        Button calc = new Button("Calculate");
        box3_3.setSpacing(6);
        box3_3.getChildren().addAll(l7,m1,m2,m3,calc);
        
        HBox box3 = new HBox();
        box3.setSpacing(50);
        box3.getChildren().addAll(box3_1,box3_2,box3_3);
        
        
        
        HBox box5 = new HBox();
        Label l8 = new Label("Total:");
        l8.setStyle("-fx-font-weight:bold;-fx-font-size:15px;");
        Label total = new Label("0");
        total.setStyle("-fx-font-size:15px;");
        Label l9 = new Label("Average:");
        l9.setStyle("-fx-font-weight:bold;-fx-font-size:15px;");
        Label avg = new Label("0");
        avg.setStyle("-fx-font-size:15px;");
        Label l10 = new Label("Grade:");
        l10.setStyle("-fx-font-weight:bold;-fx-font-size:15px;");
        Label grd = new Label("N/A");
        grd.setStyle("-fx-font-size:15px;");
        Label msg = new Label();
        msg.setStyle("-fx-text-fill:red;-fx-font-size:12px;");
        box5.setSpacing(13);
        box5.getChildren().addAll(l8,total,l9,avg,l10,grd,msg);
        
        TextArea outp = new TextArea();
        outp.setMaxHeight(80);
        outp.setMaxWidth(450);
        
        HBox butbox = new HBox();
        Button b1 = new Button("Insert");
        Button b2 = new Button("Select");
        Button b3 = new Button("Select ID");
        Button b4 = new Button("Delete");
        Button b5 = new Button("Update");
        Button b6 = new Button("Clear");
        butbox.setSpacing(30);
        butbox.getChildren().addAll(b1,b2,b3,b4,b5,b6);
        
      
        VBox root = new VBox();
        root.getChildren().addAll(title,box1,box2,box3,box5,outp,butbox);
        root.setSpacing(20);
        Scene scene = new Scene(root, 520, 530);
        root.setStyle("-fx-background-color:beige;");
        root.setPadding(new Insets(25, 25, 25, 25));
        primaryStage.setTitle("Student Information System");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        calc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(((!(m1.getText().isEmpty()))&& (!(m2.getText().isEmpty())&&(!(m3.getText().isEmpty()))))){
                    msg.setText("");
                    Integer mk1 = Integer.valueOf(m1.getText());
                    Integer mk2 = Integer.valueOf(m2.getText());
                    Integer mk3 = Integer.valueOf(m3.getText());
                    Integer tot = mk1+mk2+mk3;
                    total.setText(tot.toString());
                    Integer avrg = tot/3;
                    avg.setText(avrg.toString());
                    
                    if((mk1<40)||(mk2<40)||(mk3<40)){
                        grd.setText("F");
                    }else if(avrg > 90){
                        grd.setText("S");
                    }else if(avrg > 80){
                        grd.setText("A");
                    }else if(avrg > 70){
                        grd.setText("B");
                    }else if(avrg>60){
                        grd.setText("C");
                    }else if(avrg>50){
                        grd.setText("D");
                    }else if(avrg>40){
                        grd.setText("F");
                    }
                }else{
                    msg.setText("\tPlease enter all 3 marks!");
                }
                
                
                subjs.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov,String old_val, String new_val)->{
                    subject = new_val;
                });
                
                yearbox.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                     public void handle(ActionEvent event){
                    yr=yearbox.getValue().toString();
                    
                }
            });
                
                b1.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event) {
                        String sft,lang="";
                        
                        try{
                            Class.forName("org.apache.derby.jdbc.ClientDriver");
                            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/rithika","rithika","rithika");
                            PreparedStatement ps = con.prepareStatement("insert into studentinfo values(?,?,?,?,?,?,?,?,?,?,?,?)");
                            ps.setString(1,(deptno.getText()));
                            ps.setString(2, (name.getText()));
                            if(rb1.isSelected()){
                                sft="S I";
                            }else{
                                sft="S II";
                            }
                            ps.setString(3,sft);
                            ps.setString(4,yr);
                            ps.setString(5,subject);
                            if(ck1.isSelected()){
                                lang="English";
                            }if(ck2.isSelected()){
                                lang+="Tamil";
                            } if(ck3.isSelected()){
                                lang+="Telugu";
                            } if(ck4.isSelected()){
                                lang+="Hindi";
                            } if(ck5.isSelected()){
                                lang+="Others";
                            }
                            ps.setString(6,lang);
                            ps.setInt(7, Integer.parseInt(m1.getText()));
                            ps.setInt(8, Integer.parseInt(m2.getText()));
                            ps.setInt(9,Integer.parseInt(m3.getText()));
                            ps.setInt(10,Integer.parseInt(total.getText()));
                            ps.setInt(11,Integer.parseInt(avg.getText()));
                            ps.setString(12,grd.getText());
                            int r = ps.executeUpdate();
                            outp.appendText(r+" Record inserted successfully.");
                        } catch (Exception ex) {
                            System.out.println(ex);
                        } 
                        
                    }
                    
                });
                
                b2.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event) {
                        try{
                            Class.forName("org.apache.derby.jdbc.ClientDriver");
                            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/rithika","rithika","rithika");
                            PreparedStatement ps = con.prepareStatement("SELECT * from studentinfo");
                            ResultSet rs = ps.executeQuery();
                            
                            while(rs.next()){
                                String _name = rs.getString("name");
                                String _deptno = rs.getString("deptno");
                                String _shift = rs.getString("shift");
                                String _year = rs.getString("studyear");
                                String _subject = rs.getString("subject");
                                String _lang = rs.getString("languages");
                                String _m1 = rs.getString("mark1");
                                String _m2 = rs.getString("mark2");
                                String _m3 = rs.getString("mark3");
                                String _total = rs.getString("total");
                                String _avg = rs.getString("average");
                                String _grade = rs.getString("grade");
                                outp.appendText("NAME: "+_name+" DEPT NO: "+_deptno+" SHIFT: "+_shift+" YEAR: "+_year+"\nSUBJECT: "+_subject+" LANGUAGES: "+_lang+"\nMARK1: "+_m1+" MARK2: "+_m2+" MARK3: "+_m3+"\nTOTAL: "+_total+" AVERAGE: "+_avg+" GRADE: "+_grade+"\n\n");
                            }
                        }catch(Exception e){
                            System.out.print(e);
                        }
                    }
                    
                });
                
                b3.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event) {
                         try{
                             Class.forName("org.apache.derby.jdbc.ClientDriver");
                             Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/rithika","rithika","rithika");
                             PreparedStatement ps = con.prepareStatement("SELECT * from studentinfo where deptno=?");
                             ps.setString(1,deptno.getText());
                             ResultSet rs = ps.executeQuery();
                             
                             while(rs.next()){
                                 String _name = rs.getString("name");
                                String _deptno = rs.getString("deptno");
                                String _shift = rs.getString("shift");
                                String _year = rs.getString("studyear");
                                String _subject = rs.getString("subject");
                                String _lang = rs.getString("languages");
                                String _m1 = rs.getString("mark1");
                                String _m2 = rs.getString("mark2");
                                String _m3 = rs.getString("mark3");
                                String _total = rs.getString("total");
                                String _avg = rs.getString("average");
                                String _grade = rs.getString("grade");
                                outp.appendText("NAME: "+_name+" DEPT NO: "+_deptno+" SHIFT: "+_shift+" YEAR: "+_year+"\nSUBJECT: "+_subject+" LANGUAGES: "+_lang+"\nMARK1: "+_m1+" MARK2: "+_m2+" MARK3: "+_m3+"\nTOTAL: "+_total+" AVERAGE: "+_avg+" GRADE: "+_grade+"\n\n");
                             }
                         }catch(Exception e){
                             System.out.println(e);
                         }
                    }
                    
                });
                
                b4.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event) {
                        deptno.isFocused();
                        try{
                            Class.forName("org.apache.derby.jdbc.ClientDriver");
                            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/rithika","rithika","rithika");
                            PreparedStatement ps = con.prepareStatement("DELETE from studentinfo where deptno=?");
                            ps.setString(1,deptno.getText());
                            int rs = ps.executeUpdate();
                            outp.appendText(deptno.getText()+" record is deleted.");
                           
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    }
                    
                });
                
                b5.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event) {
                        try{
                            Class.forName("org.apache.derby.jdbc.ClientDriver");
                            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/rithika","rithika","rithika");
                            PreparedStatement ps = con.prepareStatement("update studentinfo set mark1=?,mark2=?,mark3=?,total=?,average=?,grade=? where deptno=?");
                            ps.setString(7,deptno.getText());
                            ps.setInt(1,Integer.parseInt(m1.getText()));
                            ps.setInt(2,Integer.parseInt(m2.getText()));
                            ps.setInt(3,Integer.parseInt(m3.getText()));
                            Integer _m1 = Integer.valueOf(m1.getText());
                            Integer _m2 = Integer.valueOf(m2.getText());
                            Integer _m3 = Integer.valueOf(m3.getText());
                            Integer tot = _m1+_m2+_m3;
                            total.setText(tot.toString());
                            Integer avrg = tot/3;
                            avg.setText(avrg.toString());
                            
                            if((_m1 < 40)||( _m2 < 40)||(_m3 <40)){
                                grd.setText("F");
                            }else if(avrg > 90){
                                grd.setText("S");
                            }else if(avrg>80){
                                grd.setText("A");
                            }else if(avrg>70){
                                grd.setText("B");
                            }else if(avrg>60){
                                grd.setText("C");
                            }else if(avrg>50){
                                grd.setText("D");
                            }else if(avrg>40){
                                grd.setText("F");
                            }
                            ps.setInt(4,Integer.parseInt(total.getText()));
                            ps.setInt(5,Integer.parseInt(avg.getText()));
                            ps.setString(6,(grd.getText()));
                            int r = ps.executeUpdate();
                            outp.appendText("Updated.");
                        }catch(Exception e){
                            System.out.print(e);
                        }
                    }
                    
                });
                
                b6.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event) {
                        try{
                            deptno.setText("");
                            name.setText("");
                            yearbox.getSelectionModel().clearSelection();
                            subjs.getSelectionModel().clearSelection();
                            rb1.setSelected(false);
                            rb2.setSelected(false);
                            ck1.setSelected(false);
                            ck2.setSelected(false);
                            ck3.setSelected(false);
                            ck4.setSelected(false);
                            ck5.setSelected(false);
                            m1.setText("");
                            m2.setText("");
                            m3.setText("");
                            total.setText("0");
                            avg.setText("0");
                            grd.setText("N/A");
                            outp.clear();
                            
                        }catch(Exception e)
                        {
                            System.out.print(e);
                        }
                    }
                    
                    });
                
            }
            
           

        });
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
