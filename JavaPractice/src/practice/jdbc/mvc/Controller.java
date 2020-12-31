package practice.jdbc.mvc;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
	
	private static Scanner scan = new Scanner(System.in);
	private AddressDAO addressdao;
	
	public Controller() {
		this.addressdao = new AddressDAO();
	}
	
	public void start() {
		
		boolean loop = true;
		
		while (loop) {
			
			System.out.println("[주소록]");
			System.out.println("1. 주소록 추가하기");
			System.out.println("2. 주소록 목록보기");
			System.out.println("3. 주소록 삭제하기");
			System.out.println("4. 주소록 수정하기");
			System.out.println("5. 주소록 검색하기");
			System.out.println("6. 종료");
			
			System.out.print("입력 : ");
			
			String sel = scan.nextLine();
			
			if (sel.equals("1")) {
				addAddressAdd();
			} else if (sel.equals("2")) {
				addAddressList();
			} else if (sel.equals("3")) {
				addAddressDelete();
			} else if (sel.equals("4")) {
				addAddressEdit();
			} else if (sel.equals("5")) {
				addAddressSearch();
			} else {
				loop = false;
			}
		}
		
		System.out.println("프로그램을 종료합니다.");
	}
	
	private void addAddressSearch() {
		System.out.println("[주소록 검색하기]");
		
		// 어떤 컬럼에서 검색?
		System.out.print("검색어 : ");
		String word = scan.nextLine();
		
		ArrayList<AddressDTO> list = addressdao.addressList(word);
		
		for(AddressDTO dto : list) {
			System.out.printf("%s, %s, %s, %s\n"
					, dto.getSeq()
					, dto.getName()
					, dto.getTel()
					, dto.getAddress());
		}
		System.out.println();
		
		pause();
		
	}

	private void addAddressEdit() {
		System.out.println("[주소록 수정하기]");
		
		//1. 목록 출력
		//2. 직원 번호 입력
		//3. 기존 정보 출력
		//4. 수정값 입력
		//5. UPDATE
		//6. 종료
		
		//1. 
		
		ArrayList<AddressDTO> list = addressdao.addressList(null);
		
		for(AddressDTO dto : list) {
			System.out.printf("%s, %s, %s, %s\n"
					, dto.getSeq()
					, dto.getName()
					, dto.getTel()
					, dto.getAddress());
		}
		
		//2. 직원번호입력
		System.out.print("수정할 직원 번호:");
		String seq = scan.nextLine();
		
		// seq정보를 주면 그사람의 정보를 반환시켜주는 메서드
		AddressDTO dto = addressdao.get(seq);
		
		System.out.println("번호 : " + dto.getSeq());
		System.out.println("이름 : " + dto.getName());
		System.out.println("나이 : " + dto.getAge());
		System.out.println("성별 : " + dto.getGender());
		System.out.println("전화 : " + dto.getTel());
		System.out.println("주소 : " + dto.getAddress());
		
		System.out.println("** 수정을 하지 않는 컬럼은 엔터를 입력하시오");
		System.out.print("수정할 이름 : ");
		String name = scan.nextLine();
		
		if(name.equals("")) {
			name = dto.getName();
		}
		
		System.out.print("수정할 나이 : ");
		String age = scan.nextLine();
		
		if(age.equals("")) {
			age = dto.getAge();
		}
		
		System.out.print("수정할 성별 : ");
		String gender = scan.nextLine();
		
		if(gender.equals("")) {
			gender = dto.getGender();
		}
		
		System.out.print("수정할 전화번호 : ");
		String tel = scan.nextLine();
		
		if(tel.equals("")) {
			tel = dto.getTel();
		}
		
		System.out.print("수정할 주소 : ");
		String address = scan.nextLine();
		
		if(address.equals("")) {
			address = dto.getAddress();
		}
		
		
		// dto2객체에는 수정된 레코드 값을 넣는다
		// name, age, gender, tel, address
		
		AddressDTO dto2 = new AddressDTO();
		dto2.setSeq(dto.getSeq());
		dto2.setName(name);
		dto2.setAge(age);
		dto2.setGender(gender);
		dto2.setTel(tel);
		dto2.setAddress(address);
		
		int result = addressdao.addressEdit(dto2);
		
		if (result > 0 ) { 
			System.out.println("주소록 수정 성공");
		} else {
			System.out.println("주소록 수정 실패");
		}
		
		
		pause();
		
	}

	private void addAddressDelete() {
		System.out.println("[주소록 삭제하기]");
		
		ArrayList<AddressDTO> list = addressdao.addressList(null);
		
		for (AddressDTO dto : list) {
			System.out.printf("%s - %s\n", dto.getSeq(), dto.getName());
		}
		System.out.println();
		
		System.out.print("삭제할 직원 번호 : ");
		String seq = scan.nextLine();
		
		int result = addressdao.addressDelete(seq);
		
		if(result > 0) {
			System.out.println("주소록 삭제 성공");
		} else {
			System.out.println("주소록 삭제 실패");
		}
		
		pause();
		
	}

	private void addAddressList() {
		
		System.out.println("[주소록 조회하기]");
				
		// 주소록 목록 출력
		// main 메서드에 JDBC관련 코드가 있으면 안된다
		// ResultSet -> (변환) -> ArrayList<AddressDTO>
		// ResultSet -> 레코드의 집합 -> 레코드 -> 컬럼(셀)의 집합
		// ArrayList -> AddressDTO 집합 -> AddressDTO 하나 -> 컬럼의 집합
		ArrayList<AddressDTO> list = addressdao.addressList(null);	
		System.out.println(list.size());
		
		// ResultSet -> 탐색 + 조작
		// ArrayList -> 탐색 + 조작
		// ArrayList 로 탐색 + 조작하는게 훨씬 편하다
		for(AddressDTO dto : list) {
			System.out.printf("%s, %s, %s, %s\n"
					, dto.getSeq()
					, dto.getName()
					, dto.getTel()
					, dto.getAddress());
		}
		System.out.println();
		
		pause();
		
	}

	private void addAddressAdd() {
		
		System.out.println("[주소록 추가하기]");
		
		// 1, scan -> 입력
		// ======= DB 작업 =======
		// 2. Connection 연결
		// 3. SQL 작성
		// 4. Statement 생성 + 실행
		// 5. 결과 받음
		// =======================
		// 6. 마무리 작업
		
		System.out.print("이름 : ");
		String name = scan.nextLine();
		
		System.out.print("나이 : ");
		String age = scan.nextLine();
		
		System.out.print("성별(m|f) : ");
		String gender = scan.nextLine();
		
		System.out.print("전화번호 : ");
		String tel = scan.nextLine();
		
		System.out.print("주소 : ");
		String address = scan.nextLine();
		
		// DB 작업을 위임하겠다
		// DB작업을 DAO에게 넘긴다.
		// 객체의 위치를 멤버변수로 or 지역변수로
		// AddressDAO dao = new AddressDAO();
		
		//int result = dao.add(name, age, gender, tel, address);
		
		AddressDTO dto = new AddressDTO();
		dto.setName(name);
		dto.setAge(age);
		dto.setGender(gender);
		dto.setTel(tel);
		dto.setAddress(address);
		
		// 현재 프로그래밍 방식 -> 계층과 계층관의 관계가 단순화된것을 추구
		int result =addressdao.addressAdd(dto);
		
		if (result == 1) {
			System.out.println("주소록 추가 성공");
		} else {
			System.out.println("주소록 추가 실패");
		}
				
				
		pause();
		
	}
	
	private static void pause() {
		
		System.out.println("계속하시려면 엔터를 누르세요.");
		scan.nextLine();
		
	}

}
