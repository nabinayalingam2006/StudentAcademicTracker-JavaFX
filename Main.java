import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

        @Override
        public void start(Stage stage) {

                Label title = new Label("Student Academic Tracker");

                title.setStyle(
                                "-fx-font-size:24px;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-text-fill:white;");

                Label studentSection = new Label("Student Information");

                Label subjectSection = new Label("Subject Details");

                Label resultSection = new Label("Results");

                studentSection.setStyle(
                                "-fx-font-size:16px;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-text-fill:white;");

                subjectSection.setStyle(
                                "-fx-font-size:16px;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-text-fill:white;");

                resultSection.setStyle(
                                "-fx-font-size:16px;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-text-fill:white;");

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

                String buttonStyle = "-fx-background-color:#4CAF50;" +
                                "-fx-text-fill:white;" +
                                "-fx-font-weight:bold;";

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

                Label cgpaSection = new Label("CGPA Calculator");

                cgpaSection.setStyle(
                                "-fx-font-size:16px;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-text-fill:white;");

                Label gpaLabel = new Label("GPA RESULT HERE");

                TextField semesterGpaField = new TextField();

                semesterGpaField.setPromptText(
                                "Enter Semester GPA");

                Button addGpaButton = new Button("Add GPA");

                Button calculateCgpaButton = new Button("Calculate CGPA");

                addSubjectButton.setStyle(buttonStyle);
                calculateButton.setStyle(buttonStyle);
                saveButton.setStyle(buttonStyle);
                addGpaButton.setStyle(buttonStyle);
                calculateCgpaButton.setStyle(buttonStyle);

                TextArea cgpaArea = new TextArea();
                cgpaArea.setPrefHeight(120);

                cgpaArea.setEditable(false);

                Label cgpaResultLabel = new Label();

                Label chartTitle = new Label("Grade Distribution");
                chartTitle.setStyle(
                                "-fx-text-fill:white;" +
                                                "-fx-font-size:18px;" +
                                                "-fx-font-weight:bold;");

                PieChart gradeChart = new PieChart();

                gradeChart.setLabelsVisible(true);
                gradeChart.setLegendVisible(true);
                gradeChart.setPrefHeight(300);

                gradeChart.setStyle(
                                "-fx-text-fill:white;");
                gpaLabel.setWrapText(true);
                gpaLabel.setMinHeight(60);

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

                int[] oCount = { 0 };
                int[] aPlusCount = { 0 };
                int[] aCount = { 0 };
                int[] bPlusCount = { 0 };
                int[] bCount = { 0 };
                int[] cCount = { 0 };

                subjectCol.setText("SUBJECT");
                creditCol.setText("CREDIT");
                gradeCol.setText("GRADE");

                table.setStyle(
                                "-fx-font-size:14px;");

                table.setStyle(
                                "-fx-control-inner-background:#2d2d2d;" +
                                                "-fx-text-background-color:white;");

                gpaLabel.setStyle(
                                "-fx-text-fill:white;" +
                                                "-fx-font-size:16px;" +
                                                "-fx-font-weight:bold;");

                cgpaResultLabel.setStyle(
                                "-fx-text-fill:white;" +
                                                "-fx-font-size:16px;" +
                                                "-fx-font-weight:bold;");

                String fieldStyle = "-fx-control-inner-background:#2d2d2d;" +
                                "-fx-text-fill:white;" +
                                "-fx-prompt-text-fill:gray;";

                nameField.setStyle(fieldStyle);
                regField.setStyle(fieldStyle);
                deptField.setStyle(fieldStyle);
                semField.setStyle(fieldStyle);
                subjectField.setStyle(fieldStyle);
                creditField.setStyle(fieldStyle);
                semesterGpaField.setStyle(fieldStyle);

                table.setStyle(
                                "-fx-control-inner-background:#2d2d2d;" +
                                                "-fx-table-cell-border-color:#444444;" +
                                                "-fx-text-background-color:white;");

                table.lookupAll(".column-header").forEach(node -> node.setStyle("-fx-background-color:#3c3f41;"));

                cgpaArea.setStyle(
                                "-fx-control-inner-background:#2d2d2d;" +
                                                "-fx-text-fill:white;");

                addSubjectButton.setOnAction(e -> {

                        String subject = subjectField.getText();

                        String credit = creditField.getText();

                        String grade = gradeBox.getValue();

                        int gradePoint = 0;

                        switch (grade) {

                                case "O":
                                        oCount[0]++;
                                        break;

                                case "A+":
                                        aPlusCount[0]++;
                                        break;

                                case "A":
                                        aCount[0]++;
                                        break;

                                case "B+":
                                        bPlusCount[0]++;
                                        break;

                                case "B":
                                        bCount[0]++;
                                        break;

                                case "C":
                                        cCount[0]++;
                                        break;
                        }

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

                        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(

                                        new PieChart.Data("O", oCount[0]),
                                        new PieChart.Data("A+", aPlusCount[0]),
                                        new PieChart.Data("A", aCount[0]),
                                        new PieChart.Data("B+", bPlusCount[0]),
                                        new PieChart.Data("B", bCount[0]),
                                        new PieChart.Data("C", cCount[0]));

                        gradeChart.setData(pieData);

                        gradeChart.lookup(".chart-title").setStyle(
                                        "-fx-text-fill: white;");

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

                VBox root = new VBox(20);

                root.setPadding(new Insets(20));

                root.setStyle(
                                "-fx-background-color: #1e1e1e;");

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
                                chartTitle,
                                gradeChart,

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

                                cgpaResultLabel

                );

                ScrollPane scrollPane = new ScrollPane(root);

                scrollPane.setFitToWidth(true);

                Scene scene = new Scene(scrollPane, 900, 800);

                stage.setTitle("Student Academic Tracker");
                stage.setScene(scene);
                stage.show();
        }

        public static void main(String[] args) {
                launch();
        }
}