package junwon.mainMenu;
import chanhee.MovieView;
import util.SimpleInput;

public class MainView {

    public static void showMainView(){
        System.out.println("️‍🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈");
        System.out.println("          ChoonGangmoVie Club           ");
        System.out.println("🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈");
        System.out.println("1.  회  원  가  입                    ");
        System.out.println("2.  상  영  중  영  화                ");
        System.out.println("3.  ?                                ");
        System.out.println("🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈");
        System.out.println("");





        while (true) {
            String menuNum = SimpleInput.input(">> 메뉴번호 : ");

            switch (menuNum){
                case "1":
                    MovieView mv = new MovieView();
                    mv.movie();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                default:
                    System.out.println("잘못된 메뉴입니다.");
            }
        }

    }

}