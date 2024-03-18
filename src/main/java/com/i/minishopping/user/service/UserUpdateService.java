package com.i.minishopping.user.service;

import org.springframework.stereotype.Service;


//@Setter
@Service
public class UserUpdateService implements UserService{
    @Override
    public void execute() {

    }

    /*@Autowired
    private UserDAO userDAO;

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println();

        List<UserDTO> list = userDAO.getUserList();

        System.out.print("수정할 아이디 입력 : ");
        String id = sc.next();

        int sw = 0;
        for(UserDTO userDTO : list) {

            if(userDTO.getId().equals(id)) {

                System.out.println(userDTO);
                System.out.println();

                System.out.print("수정할 이름 입력 : ");
                String name = sc.next();

                System.out.println("수정할 비밀번호 입력 : ");
                String pwd = sc.next();

                userDTO.setName(name);
                userDTO.setId(userDTO.getId());
                userDTO.setPwd(pwd);

                userDAO.updateUser(userDTO);
                sw = 1;
                System.out.println("수정을 완료했습니다.");

                break;

            } // if

        } // enhanced for

        if(sw == 0) {
            System.out.println("아이디가 존재하지 않습니다.");
        } // if



    } // execute
*/
} // end class
