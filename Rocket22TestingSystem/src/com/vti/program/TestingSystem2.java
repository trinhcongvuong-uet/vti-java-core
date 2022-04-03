package com.vti.program;

import java.lang.reflect.Field;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.GroupAccount;
import com.vti.entity.Position;
import com.vti.entity.PositionNameEnum;

public class TestingSystem2 {

	public static void main(String[] args) {
		// tạo danh sách account -> Mình sử dụng vòng lặp để tạo nhé
		// Đây là cách tạo mảng Account[] có 10 phần tử, các phần tử chưa được khởi tạo
		Account[] accountList = new Account[10];

		Department[] departmentList = new Department[10];
		for (int i = 0; i < departmentList.length; i++) {
			Department department = new Department();
			department.setDepartmentId(i + 1);
			department.setDepartmentName("Department " + (i + 1));

			departmentList[i] = department;
		}

		Position position = new Position();
		position.setPositionId(1L);
		position.setPositionName(PositionNameEnum.DEV);

		// Dùng vòng lặp để khởi tạo từng phần tử cho mảng accountList
		for (int i = 0; i < accountList.length; i++) {
			// tạo Account
			Account account = new Account();
			account.setAccountId(i);
			account.setEmail(String.format("email%s@gmail.com", i));
			account.setFullName(String.format("Account %s", i));
			account.setDepartment(departmentList[0]);
			account.setPosition(position);

			// Set account vừa tạo vào phần tử thứ i của mảng
			accountList[i] = account;
		}

		// Tạo mảng Group[] tương tự mảng Account[]
		Group[] groupList = new Group[10];
		for (int i = 0; i < groupList.length; i++) {
			Group group = new Group();
			group.setGroupId(1000L + i);

			groupList[i] = group;
		}

		// Tạo mảng GroupAccount[] tương tự mảng Account[]
		GroupAccount[] groupAccountList = new GroupAccount[10];
		for (int i = 0; i < groupAccountList.length; i++) {
			GroupAccount groupAccount = new GroupAccount();

			// Thiết định account và group -> Như này thì account thứ i trong accountList sẽ thuộc group thứ i trong groupList
			groupAccount.setGroup(groupList[i]);
			groupAccount.setAccount(accountList[i]);

			groupAccountList[i] = groupAccount;

		}

//		// question 1
//		question1(accountList[1]);
//
//		// question 2
//		question2(accountList[1], groupAccountList);
//
//		// question 3
//		question3(accountList[1]);
//
//		// question 4
//		question4(accountList[0]);
//
//		// question 5
//		question5(groupList[0], groupAccountList);
//
//		// question 6
//		question6(accountList[1], groupAccountList);
//
//		// question 7
//		question7(accountList[0]);
//
//		// question 8
//		question8(accountList);
//
//		// question 9
//		question9(departmentList);
//
//		// question 10
//		question10(accountList);
//
//		// question 11
//		question11(departmentList);
//
//		// question 12
//		question12(departmentList);
//
//		// question 13
//		question13(accountList);
//
//		// question 14
//		question14(accountList);
//
//		// question 15
//		question15();
//
//		// question 16
//		question16_1(accountList);
//		question16_2(departmentList);
//		question16_3(departmentList);
//		question16_4(accountList);
//		question16_5(accountList);
//		question16_6();
//
//		// question 17
//		question17_1(accountList);
//		question17_2(departmentList);
//		question17_3(departmentList);
//		question17_4(accountList);
//		question17_5(accountList);
//		question17_6();

	}

	private static void question1(Account account) {
		// Câu lệnh này để in ra tên method thôi mọi người không cần quan tâm nhé
		System.out.print("=========");
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + "=========");

		// Xử lý chính
		if (account.getDepartment() == null) {
			System.out.println("Nhân viên này chưa có phòng ban");
		} else {
			System.out.println("Phòng ban của nhân viên này là " + account.getDepartment().getDepartmentName());
		}
	}

	private static void question2(Account account, GroupAccount[] groupAccountList) {
		// Câu lệnh này để in ra tên method thôi mọi người không cần quan tâm nhé
		System.out.print("=========");
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + "=========");

		// Xử lý chính

		// Tạo 1 biến để lưu số lượng group mà có account thuộc vào
		int countGroup = 0;

		for (GroupAccount groupAccount : groupAccountList) {
			// Kiểm tra xem Account.accountID = accountId của account hay không?
			if (account.getAccountId() == groupAccount.getAccount().getAccountId()) {
				// tăng số lượng countGroup
				countGroup++;
			}
		}

		/*
		Nếu không có group thì in ra text "Nhân viên chưa có group"
		Nếu có mặt trong 1 hoặc 2 group thì in ra text "Group của nhân viên này là Java Fresher, C# Fresher"
		Nếu có mặt trong 3 group thi in ra text "Nhân viên này là người quan trọng, tham gia nhiều group"
		Nếu có mặt trong 4 group trở lên thì on ra text "Nhân viên này là người qhóng chuyện, tham gia tất cả group"
		*/
		if (countGroup == 0) {
			System.out.println("Nhân viên chưa có group");
		} else if (countGroup == 1 || countGroup == 2) {
			System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
		} else if (countGroup == 3) {
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
		} else {
			System.out.println("Nhân viên này là người qhóng chuyện, tham gia tất cả group");
		}
	}

	private static void question3(Account account) {

		// Câu lệnh này để in ra tên method thôi mọi người không cần quan tâm nhé
		System.out.print("=========");
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + "=========");

		// Xử lý chính

		String content = account.getDepartment() == null ? "Nhân viên này chưa có phòng ban"
				: ("Phòng ban của nhân viên này là " + account.getDepartment().getDepartmentName());

		System.out.println(content);
	}

	private static void question4(Account account) {
		// Câu lệnh này để in ra tên method thôi mọi người không cần quan tâm nhé
		System.out.print("=========");
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + "=========");

		// Xử lý chính

		String content = account.getPosition().getPositionName() == PositionNameEnum.DEV ? "Đây là Developer"
				: "Người này không phải Developer";
		System.out.println(content);
	}

	private static void question5(Group group, GroupAccount[] groupAccountList) {
		// Câu lệnh này để in ra tên method thôi mọi người không cần quan tâm nhé
		System.out.print("=========");
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + "=========");

		// Xử lý chính

		int countAccount = 0;
		for (GroupAccount groupAccount : groupAccountList) {
			if (groupAccount.getGroup().getGroupId() == group.getGroupId()) {
				countAccount++;
			}
		}

		switch (countAccount) {
		case 0:
			System.out.println("Nhóm không có thành viên nào");
			break;
		case 1:
			System.out.println("Nhóm có một thành viên");
			break;
		case 2:
			System.out.println("Nhóm có hai thành viên");
			break;
		case 3:
			System.out.println("Nhóm có ba thành viên");
			break;

		default:
			System.out.println("Nhóm có nhiều thành viên");
			break;
		}

//		if (countAccount == 1) {
//			System.out.println("Nhóm có một thành viên");
//		} else if (countAccount == 2) {
//			System.out.println("Nhóm có hai thành viên");
//		} else if (countAccount == 3) {
//			System.out.println("Nhóm có ba thành viên");
//		} else {
//			System.out.println("Nhóm có nhiều thành viên");
//		}
	}

	private static void question6(Account account, GroupAccount[] groupAccountList) {
		// Câu lệnh này để in ra tên method thôi mọi người không cần quan tâm nhé
		System.out.print("=========");
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + "=========");

		// Xử lý chính

		int countGroup = 0;

		for (GroupAccount groupAccount : groupAccountList) {
			if (account.getAccountId() == groupAccount.getAccount().getAccountId()) {
				countGroup++;
			}
		}

		switch (countGroup) {
		case 0:
			System.out.println("Nhân viên chưa có group");
			break;

		case 1:
		case 2:
			System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
			break;
		case 3:
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
			break;

		default:
			System.out.println("Nhân viên này là người qhóng chuyện, tham gia tất cả group");
			break;
		}
	}

	private static void question7(Account account) {
		// Câu lệnh này để in ra tên method thôi mọi người không cần quan tâm nhé
		System.out.print("=========");
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + "=========");

		// Xử lý chính

		switch (account.getPosition().getPositionName()) {
		case DEV:
			System.out.println("Đây là Developer");
			break;

		default:
			System.out.println("Người này không phải Developer");
			break;
		}
	}

	private static void question8(Account[] accountList) {
		// Câu lệnh này để in ra tên method thôi mọi người không cần quan tâm nhé
		System.out.print("=========");
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + "=========");

		// Xử lý chính

		for (Account account : accountList) {
			System.out.println("Email: " + account.getEmail());
			System.out.println("Full name: " + account.getFullName());
			System.out.println("Phòng ban: " + account.getDepartment().getDepartmentName());
			System.out.println();
		}
	}

	private static void question9(Department[] departmentList) {
		System.out.print("=========");
		// Câu lệnh này để in ra tên method thôi mọi người không cần quan tâm nhé
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + "=========");

		// Xử lý chính

		for (Department department : departmentList) {
			System.out.println("Department id: " + department.getDepartmentId());
			System.out.println("Department name: " + department.getDepartmentName());
			System.out.println();
		}
	}

	private static void question10(Account[] accountList) {
		// Câu lệnh này để in ra tên method thôi mọi người không cần quan tâm nhé
		System.out.print("=========");
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + "=========");

		// Xử lý chính

		for (int i = 0; i < accountList.length; i++) {
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accountList[i].getEmail());
			System.out.println("Full name: " + accountList[i].getFullName());
			System.out.println("Phòng ban: " + accountList[i].getDepartment().getDepartmentName());
			System.out.println();
		}
	}

	private static void question11(Department[] departmentList) {
		// Câu lệnh này để in ra tên method thôi mọi người không cần quan tâm nhé
		System.out.print("=========");
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + "=========");

		// Xử lý chính

		for (int i = 0; i < departmentList.length; i++) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + departmentList[i].getDepartmentId());
			System.out.println("Name: " + departmentList[i].getDepartmentName());
			System.out.println();
		}
	}

	private static void question12(Department[] departmentList) {
		// Câu lệnh này để in ra tên method thôi mọi người không cần quan tâm nhé
		System.out.print("=========");
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + "=========");

		// Xử lý chính

		for (int i = 0; i < 2; i++) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + departmentList[i].getDepartmentId());
			System.out.println("Name: " + departmentList[i].getDepartmentName());
			System.out.println();
		}
	}

	private static void question13(Account[] accountList) {
		// Câu lệnh này để in ra tên method thôi mọi người không cần quan tâm nhé
		System.out.print("=========");
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + "=========");

		// Xử lý chính

		for (int i = 0; i < accountList.length; i++) {
			if (i != 1) {
				System.out.println("Email: " + accountList[i].getEmail());
				System.out.println("Full name: " + accountList[i].getFullName());
				System.out.println("Phòng ban: " + accountList[i].getDepartment().getDepartmentName());
				System.out.println();
			}

//			if (i == 1) {
//				continue;
//			}
//			System.out.println("Email: " + accountList[i].getEmail());
//			System.out.println("Full name: " + accountList[i].getFullName());
//			System.out.println("Phòng ban: " + accountList[i].getDepartment().getDepartmentName());
//			System.out.println();
		}
	}

	private static void question14(Account[] accountList) {
		// Câu lệnh này để in ra tên method thôi mọi người không cần quan tâm nhé
		System.out.print("=========");
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + "=========");

		// Xử lý chính

		for (int i = 0; i < accountList.length; i++) {
			if (accountList[i].getAccountId() < 4) {
				System.out.println("Email: " + accountList[i].getEmail());
				System.out.println("Full name: " + accountList[i].getFullName());
				System.out.println("Phòng ban: " + accountList[i].getDepartment().getDepartmentName());
				System.out.println();
			}

//			if (accountList[i].getAccountId() >= 4) {
//				continue;
//			}
//			System.out.println("Email: " + accountList[i].getEmail());
//			System.out.println("Full name: " + accountList[i].getFullName());
//			System.out.println("Phòng ban: " + accountList[i].getDepartment().getDepartmentName());
//			System.out.println();
		}
	}

	private static void question15() {
		// Câu lệnh này để in ra tên method thôi mọi người không cần quan tâm nhé
		System.out.print("=========");
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + "=========");

		// Xử lý chính

		for (int i = 0; i <= 20; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
	}

	private static void question16_1(Account[] accountList) {
		// Câu lệnh này để in ra tên method thôi mọi người không cần quan tâm nhé
		System.out.print("=========");
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + "=========");

		// Xử lý chính

		int i = 0;
		while (i < accountList.length) {
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accountList[i].getEmail());
			System.out.println("Full name: " + accountList[i].getFullName());
			System.out.println("Phòng ban: " + accountList[i].getDepartment().getDepartmentName());
			System.out.println();

			i++;
		}
	}

	private static void question16_2(Department[] departmentList) {
		// Câu lệnh này để in ra tên method thôi mọi người không cần quan tâm nhé
		System.out.print("=========");
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + "=========");

		// Xử lý chính

		int i = 0;
		while (i < departmentList.length) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + departmentList[i].getDepartmentId());
			System.out.println("Name: " + departmentList[i].getDepartmentName());
			System.out.println();

			i++;
		}
	}

	private static void question16_3(Department[] departmentList) {
		// Câu lệnh này để in ra tên method thôi mọi người không cần quan tâm nhé
		System.out.print("=========");
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + "=========");

		// Xử lý chính

		int i = 0;
		while (i < 2) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + departmentList[i].getDepartmentId());
			System.out.println("Name: " + departmentList[i].getDepartmentName());
			System.out.println();

			i++;
		}
	}

	private static void question16_4(Account[] accountList) {
		// Câu lệnh này để in ra tên method thôi mọi người không cần quan tâm nhé
		System.out.print("=========");
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + "=========");

		// Xử lý chính

		int i = 0;
		while (i < accountList.length) {
			if (i != 1) {
				System.out.println("Email: " + accountList[i].getEmail());
				System.out.println("Full name: " + accountList[i].getFullName());
				System.out.println("Phòng ban: " + accountList[i].getDepartment().getDepartmentName());
				System.out.println();
			}

//			if (i == 1) {
//				continue;
//			}
//			System.out.println("Email: " + accountList[i].getEmail());
//			System.out.println("Full name: " + accountList[i].getFullName());
//			System.out.println("Phòng ban: " + accountList[i].getDepartment().getDepartmentName());
//			System.out.println();

			i++;
		}
	}

	private static void question16_5(Account[] accountList) {
		// Câu lệnh này để in ra tên method thôi mọi người không cần quan tâm nhé
		System.out.print("=========");
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + "=========");

		// Xử lý chính

		int i = 0;
		while (i < accountList.length) {
			if (accountList[i].getAccountId() < 4) {
				System.out.println("Email: " + accountList[i].getEmail());
				System.out.println("Full name: " + accountList[i].getFullName());
				System.out.println("Phòng ban: " + accountList[i].getDepartment().getDepartmentName());
				System.out.println();
			}

//			if (accountList[i].getAccountId() >= 4) {
//				continue;
//			}
//			System.out.println("Email: " + accountList[i].getEmail());
//			System.out.println("Full name: " + accountList[i].getFullName());
//			System.out.println("Phòng ban: " + accountList[i].getDepartment().getDepartmentName());
//			System.out.println();

			i++;
		}
	}

	private static void question16_6() {
		// Câu lệnh này để in ra tên method thôi mọi người không cần quan tâm nhé
		System.out.print("=========");
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + "=========");

		// Xử lý chính

		int i = 0;
		while (i <= 20) {
			if (i % 2 == 0) {
				System.out.println(i);
			}

			i++;
		}
	}

	private static void question17_1(Account[] accountList) {
		// Câu lệnh này để in ra tên method thôi mọi người không cần quan tâm nhé
		System.out.print("=========");
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + "=========");

		// Xử lý chính

		int i = 0;
		do {
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accountList[i].getEmail());
			System.out.println("Full name: " + accountList[i].getFullName());
			System.out.println("Phòng ban: " + accountList[i].getDepartment().getDepartmentName());
			System.out.println();

			i++;
		} while (i < accountList.length);
	}

	private static void question17_2(Department[] departmentList) {
		// Câu lệnh này để in ra tên method thôi mọi người không cần quan tâm nhé
		System.out.print("=========");
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + "=========");

		// Xử lý chính

		int i = 0;
		do {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + departmentList[i].getDepartmentId());
			System.out.println("Name: " + departmentList[i].getDepartmentName());
			System.out.println();

			i++;
		} while (i < departmentList.length);
	}

	private static void question17_3(Department[] departmentList) {
		// Câu lệnh này để in ra tên method thôi mọi người không cần quan tâm nhé
		System.out.print("=========");
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + "=========");

		// Xử lý chính

		int i = 0;
		do {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + departmentList[i].getDepartmentId());
			System.out.println("Name: " + departmentList[i].getDepartmentName());
			System.out.println();

			i++;
		} while (i < 2);
	}

	private static void question17_4(Account[] accountList) {
		// Câu lệnh này để in ra tên method thôi mọi người không cần quan tâm nhé
		System.out.print("=========");
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + "=========");

		// Xử lý chính

		int i = 0;
		do {
			if (i != 1) {
				System.out.println("Email: " + accountList[i].getEmail());
				System.out.println("Full name: " + accountList[i].getFullName());
				System.out.println("Phòng ban: " + accountList[i].getDepartment().getDepartmentName());
				System.out.println();
			}

//			if (i == 1) {
//				continue;
//			}
//			System.out.println("Email: " + accountList[i].getEmail());
//			System.out.println("Full name: " + accountList[i].getFullName());
//			System.out.println("Phòng ban: " + accountList[i].getDepartment().getDepartmentName());
//			System.out.println();

			i++;
		} while (i < accountList.length);
	}

	private static void question17_5(Account[] accountList) {
		// Câu lệnh này để in ra tên method thôi mọi người không cần quan tâm nhé
		System.out.print("=========");
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + "=========");

		// Xử lý chính

		int i = 0;
		do {
			if (accountList[i].getAccountId() < 4) {
				System.out.println("Email: " + accountList[i].getEmail());
				System.out.println("Full name: " + accountList[i].getFullName());
				System.out.println("Phòng ban: " + accountList[i].getDepartment().getDepartmentName());
				System.out.println();
			}

//			if (accountList[i].getAccountId() >= 4) {
//				continue;
//			}
//			System.out.println("Email: " + accountList[i].getEmail());
//			System.out.println("Full name: " + accountList[i].getFullName());
//			System.out.println("Phòng ban: " + accountList[i].getDepartment().getDepartmentName());
//			System.out.println();

			i++;
		} while (i < accountList.length);
	}

	private static void question17_6() {
		// Câu lệnh này để in ra tên method thôi mọi người không cần quan tâm nhé
		System.out.print("=========");
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + "=========");

		// Xử lý chính

		int i = 0;
		do {
			if (i % 2 == 0) {
				System.out.println(i);
			}

			i++;
		} while (i <= 20);
	}
}
