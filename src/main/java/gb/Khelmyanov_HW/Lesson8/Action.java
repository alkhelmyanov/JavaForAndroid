package gb.Khelmyanov_HW.Lesson8;

public class Action {
String typeOfRunner;

    protected void methodRun(String typeOfRunner, String name){
        if (RunningTrack.getDistance() > 500) {
            System.out.println(typeOfRunner + " по имени \"" + name + "\" не может пробежать больше 500м");
        } else {
            System.out.println(typeOfRunner + " то имени \"" + name + "\" пробежал " + RunningTrack.getDistance()+"м");
        }
    }
    public void methodJump(String typeOfRunner, String name) {
        if (Wall.getHeight() > 15) {
            System.out.println(typeOfRunner + " не может перелезть препятствие выше 15м, боится убиться!!!");
        } else {
            System.out.println(typeOfRunner + " перелез стену " + Wall.getHeight()+ "м");
        }
    }

}
