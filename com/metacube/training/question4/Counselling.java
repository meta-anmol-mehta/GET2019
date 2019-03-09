package com.metacube.training.question4;

import java.io.File;
import java.io.IOException;

import com.metacube.training.question3.Queue;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


public class Counselling {

	private Program programList[];
	private int size;
	private StudentAllocationList studentsList[];
	private int size1= 0;

	public void programs() {

		try {
			Workbook workbook = Workbook.getWorkbook(
					new java.io.File(" Programs.xls"));
			// Obtain the reference to the first sheet in the workbook
			Sheet sheet = workbook.getSheet(0);
			// Obtain reference to the Cell using getCell(int col, int row)
			// method of sheet
			this.programList = new Program[sheet.getRows()];
			String programName = null;
			int capacity = 0;
			for (int i = 0; i < sheet.getRows(); i++) {
				for (int j = 0; j < sheet.getColumns(); j++) {
					Cell cell = sheet.getCell(j, i);
					CellType type = cell.getType();
					if (type == CellType.LABEL) {
						programName = cell.getContents();
					} else if (type == CellType.NUMBER) {
						capacity = Integer.parseInt(cell.getContents());
					}
				}
				Program p = new Program(programName, capacity);
				this.programList[i] = p;
			}
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void allocate(Queue<StudentNode> queue)  {
		this.studentsList = new StudentAllocationList[size];
		int count3=0;
		while (!queue.isEmpty()) {
			StudentNode student = (StudentNode) queue.remove();
			String preferences[] = student.getData();
			outerloop: for (int count1 = 0; count1 < preferences.length; count1++) {
				for (int count = 0; count < this.programList.length; count++) {
					String programName = this.programList[count].getName();
					if (preferences[count1].equalsIgnoreCase(programName)) {
						int remaining = programList[count].getRemainig();
						if (remaining > 0) {
							String allocatedProgram = programName;
							String name = student.getName();
							StudentAllocationList st = new StudentAllocationList(name, allocatedProgram);
							//System.out.println(allocatedProgram);
							studentsList[count3] = st;
							count3++;
							size1++;
							programList[count].setRemainig(remaining - 1);
							break outerloop;
						}
					}

				}

			}

		}
	}

	public void updateExcel() throws IOException {
		
		int i=0;
		try {
			WritableWorkbook workbook = Workbook.createWorkbook(
					new File(" allocationList.xls"));
			WritableSheet wSheet = workbook.createSheet("sheet1",0);
			int count1;
			//Label labTemp1;
			String program1 = this.studentsList[4].getAllocatedProgram();
			//System.out.println("CHECK " + program1);
			for (count1 = 0; count1 < this.size1; count1++) {
				String name= this.studentsList[i].getName();
				Label labTemp1 = new Label(0, count1, name);
				wSheet.addCell(labTemp1);
				String program = this.studentsList[i].getAllocatedProgram();
				Label labTemp2 = new Label(1, count1, program);
				i++;
				wSheet.addCell(labTemp2);
				
			}
			
			workbook.write();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	public Queue<StudentNode> addStudents()  {
		this.size = 0;
		Queue<StudentNode> queue = new StudentsQueue<StudentNode>(25);
		try {
			Workbook workbook = Workbook.getWorkbook(
					new java.io.File(" Students.xls"));
			// Obtain the reference to the first sheet in the workbook
			Sheet sheet = workbook.getSheet(0);
			// Obtain reference to the Cell using getCell(int col, int row)
			// method of sheet

		//	queue = new QueueUsingArray<>(sheet.getRows());
			this.size = sheet.getRows();

			for (int i = 0; i < sheet.getRows(); i++) {
				Cell name = sheet.getCell(0, i);
				String studentName = name.getContents();
				String[] pref = new String[5];
				for (int j = 1; j < sheet.getColumns(); j++) {
					Cell cell = sheet.getCell(j, i);
					CellType type = cell.getType();
					if (type == CellType.LABEL) {
						pref[j - 1] = cell.getContents();
					}
				}
				StudentNode student = new StudentNode(studentName, pref);
				queue.insert(student);

			}
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return queue;

	}

	public static void main(String[] args) {
		Counselling c = new Counselling();
		c.programs();
		Queue<StudentNode> queue = c.addStudents();
		c.allocate(queue);
		try {
			c.updateExcel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}