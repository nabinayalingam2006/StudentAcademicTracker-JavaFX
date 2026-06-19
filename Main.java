import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

        @Override
        public void start(Stage stage) {

                Label title = new Label("Student Academic Tracker");

                Label studentSection = new Label("Student Information");

                Label subjectSection = new Label("Subject Details");

                Label resultSection = new Label("Results");

                studentSection.setStyle(
                                "-fx-font-size:16px; -fx-font-weight:bold;");

                subjectSection.setStyle(
                                "-fx-font-size:16px; -fx-font-weight:bold;");

                resultSection.setStyle(
                                "-fx-font-size:16px; -fx-font-weight:bold;");

                title.setStyle(
                                "-fx-font-size: 22px;" +
                                                "-fx-font-weight: bold;");

                TextField nameField = new TextField();
                nameField.setPromptText("Enter Student Name");

                TextField regField = new TextField();
                regField.setPromptText("Enter Register Number");

                TextField deptField = new TextField();
                deptField.setPromptText("Enter Department");

                TextField semField = new TextField();
                semField.setPromptText("Enter Semester");

                TextField subjectField = new TextField();
                subjectField.setPromptText("Subject Name");

                TextField creditField = new TextField();
                creditField.setPromptText("Credit");

                Button submitButton = new Button("Submit");

                ComboBox<String> gradeBox = new ComboBox<>();

                gradeBox.getItems().addAll(
                                "O",
                                "A+",
                                "A",
                                "B+",
                                "B",
                                "C");

                gradeBox.setPromptText("Select Grade");

                Button addSubjectButton = new Button("Add Subject");
                addSubjectButton.setPrefWidth(150);

                Button calculateButton = new Button("Calculate GPA");
                calculateButton.setPrefWidth(150);

                Button saveButton = new Button("Save Report");
                saveButton.setPrefWidth(150);

                Label resultLabel = new Label();

                Label cgpaSection = new Label("CGPA Calculator");

                cgpaSection.setStyle(
                                "-fx-font-size:16px; -fx-font-weight:bold;");

                Label gpaLabel = new Label("GPA will appear here");

                TextField semesterGpaField = new TextField();

                semesterGpaField.setPromptText(
                                "Enter Semester GPA");

                Button addGpaButton = new Button("Add GPA");

                Button calculateCgpaButton = new Button("Calculate CGPA");

                TextArea cgpaArea = new TextArea();
                cgpaArea.setPrefHeight(120);

                cgpaArea.setEditable(false);

                Label cgpaResultLabel = new Label();

                gpaLabel.setWrapText(true);
                gpaLabel.setMinHeight(60);

                gpaLabel.setStyle(
                                "-fx-font-size:16px;" +
                                                "-fx-font-weight:bold;");

                TableView<SubjectData> table = new TableView<>();

                TableColumn<SubjectData, String> subjectCol = new TableColumn<>("Subject");

                TableColumn<SubjectData, String> creditCol = new TableColumn<>("Credit");

                TableColumn<SubjectData, String> gradeCol = new TableColumn<>("Grade");

                subjectCol.setCellValueFactory(
                                new PropertyValueFactory<>("subject"));

                creditCol.setCellValueFactory(
                                new PropertyValueFactory<>("credit"));

                gradeCol.setCellValueFactory(
                                new PropertyValueFactory<>("grade"));

                table.getColumns().addAll(
                                subjectCol,
                                creditCol,
                                gradeCol);

                table.setPrefHeight(250);

                table.setMinHeight(250);

                table.setColumnResizePolicy(
                                TableView.CONSTRAINED_RESIZE_POLICY);

                subjectCol.setPrefWidth(400);
                creditCol.setPrefWidth(150);
                gradeCol.setPrefWidth(150);

                Label saveStatusLabel = new Label();

                gpaLabel.setWrapText(true);
                gpaLabel.setMinHeight(80);

                TextArea subjectsArea = new TextArea();

                subjectsArea.setEditable(false);
                subjectsArea.setPrefHeight(150);

                ObservableList<String> subjects = FXCollections.observableArrayList();

                double[] totalPoints = { 0 };
                int[] totalCredits = { 0 };

                java.util.ArrayList<Double> gpaList = new java.util.ArrayList<>();

                addSubjectButton.setOnAction(e -> {

                        String subject = subjectField.getText();

                        String credit = creditField.getText();

                        String grade = gradeBox.getValue();

                        int gradePoint = 0;

                        switch (grade) {
                                case "O":
                                        gradePoint = 10;
                                        break;
                                case "A+":
                                        gradePoint = 9;
                                        break;
                                case "A":
                                        gradePoint = 8;
                                        break;
                                case "B+":
                                        gradePoint = 7;
                                        break;
                                case "B":
                                        gradePoint = 6;
                                        break;
                                case "C":
                                        gradePoint = 5;
                                        break;
                        }

                        totalPoints[0] += Integer.parseInt(credit) * gradePoint;

                        totalCredits[0] += Integer.parseInt(credit);

                        String row = subject + "    |    "
                                        + credit + "    |    "
                                        + grade;

                        subjects.add(row);

                        table.getItems().add(
                                        new SubjectData(
                                                        subject,
                                                        credit,
                                                        grade));

                        subjectsArea.clear();

                        subjectsArea.appendText(
                                        "Subject | Credit | Grade\n");
                        subjectsArea.appendText(
                                        "-------------------------\n");

                        for (String s : subjects) {

                                subjectsArea.appendText(
                                                s + "\n");
                        }

                        subjectField.clear();
                        creditField.clear();
                        gradeBox.setValue(null);
                });

                calculateButton.setOnAction(e -> {

                        if (totalCredits[0] == 0) {

                                gpaLabel.setText(
                                                "No subjects added.");

                                return;
                        }

                        double gpa = totalPoints[0] / totalCredits[0];

                        String performance;

                        if (gpa >= 9) {

                                performance = "Outstanding";

                        } else if (gpa >= 8) {

                                performance = "Excellent";

                        } else if (gpa >= 7) {

                                performance = "Good";

                        } else {

                                performance = "Needs Improvement";
                        }

                        gpaLabel.setText(
                                        "GPA : "
                                                        + String.format("%.2f", gpa)
                                                        + "\nPerformance : "
                                                        + performance);

                });

                addGpaButton.setOnAction(e -> {

                        try {

                                double gpa = Double.parseDouble(
                                                semesterGpaField.getText());

                                gpaList.add(gpa);

                                cgpaArea.appendText(
                                                "Semester "
                                                                + gpaList.size()
                                                                + " GPA : "
                                                                + gpa
                                                                + "\n");

                                semesterGpaField.clear();

                        } catch (Exception ex) {

                                cgpaResultLabel.setText(
                                                "Enter valid GPA");
                        }
                });

                calculateCgpaButton.setOnAction(e -> {

                        if (gpaList.isEmpty()) {

                                cgpaResultLabel.setText(
                                                "No GPA entered");

                                return;
                        }

                        double total = 0;

                        for (double gpa : gpaList) {

                                total += gpa;
                        }

                        double cgpa = total / gpaList.size();

                        cgpaResultLabel.setText(
                                        "CGPA : "
                                                        + String.format(
                                                                        "%.2f",
                                                                        cgpa));
                });

                saveButton.setOnAction(e -> {

                        try {

                                java.io.FileWriter writer = new java.io.FileWriter(
                                                "student_report.txt");

                                writer.write(
                                                "STUDENT ACADEMIC REPORT\n\n");

                                writer.write(
                                                "Name : "
                                                                + nameField.getText()
                                                                + "\n");

                                writer.write(
                                                "Register No : "
                                                                + regField.getText()
                                                                + "\n");

                                writer.write(
                                                "Department : "
                                                                + deptField.getText()
                                                                + "\n");

                                writer.write(
                                                "Semester : "
                                                                + semField.getText()
                                                                + "\n\n");

                                writer.write(
                                                subjectsArea.getText());

                                writer.write("\n\n");

                                writer.write(
                                                gpaLabel.getText());

                                writer.close();

                                saveStatusLabel.setText(
                                                "Report Saved Successfully!");

                        } catch (Exception ex) {

                                saveStatusLabel.setText(
                                                "Error Saving Report!");
                        }
                });

                submitButton.setOnAction(e -> {

                        String name = nameField.getText();
                        String regNo = regField.getText();
                        String dept = deptField.getText();
                        String sem = semField.getText();

                        resultLabel.setText(
                                        "Name : " + name +
                                                        "\nRegister No : " + regNo +
                                                        "\nDepartment : " + dept +
                                                        "\nSemester : " + sem);
                });

                VBox root = new VBox(15);

                root.setPadding(new Insets(20));
                root.setStyle(
                                "-fx-background-color: #f5f7fa;");

                root.setPrefWidth(500);

                root.setPadding(new Insets(20));

                root.getChildren().addAll(

                                title,

                                studentSection,

                                nameField,
                                regField,
                                deptField,
                                semField,

                                subjectSection,

                                subjectField,
                                creditField,
                                gradeBox,
                                addSubjectButton,

                                table,

                                resultSection,

                                calculateButton,
                                gpaLabel,

                                saveButton,
                                saveStatusLabel,
                                cgpaSection,

                                semesterGpaField,

                                addGpaButton,

                                cgpaArea,

                                calculateCgpaButton,

                                cgpaResultLabel,

                                submitButton,
                                resultLabel);

                ScrollPane scrollPane = new ScrollPane(root);

                scrollPane.setFitToWidth(true);

                Scene scene = new Scene(scrollPane, 700, 700);

                stage.setTitle("Student Academic Tracker");
                stage.setScene(scene);
                stage.show();
        }

        public static void main(String[] args) {
                launch();
        }
}