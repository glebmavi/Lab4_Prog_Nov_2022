import ru.glebmavi.lab3.Personaje;
import ru.glebmavi.lab3.Senior;

import java.lang.reflect.InvocationTargetException;

public class Cabinet {

    Personaje owner;


    Cabinet() {
        this.owner = new Senior("Владелец Кабинета");
    }

    Cabinet(Personaje p) {
        this.owner = p;
    }

    // inner class
    class Table {

        int seats;

        // anonymous class
        Group participants = new Group() {
            public void emotion(String s, Group g) {
                for (Member m : g.integrantes) {
                    m.setEmotion(s);
                }
            }

            public void hear(String s, Group g) {
                for (Member m : g.integrantes) {
                    m.Hear(s);
                }
            }
        };

        Table(int s, Group g) throws TableNegativeSeatsException, TableFewSeatsException, TableGroupHasNoMembers {
            if (s <= 0) throw new TableNegativeSeatsException("ОШИБКА: Количество мест " + s + " должно быть больше 0");
            if (g.integrantes.isEmpty())
                throw new TableGroupHasNoMembers("ОШИБКА: Группа " + g.groupName + " не имеет участников");
            if (g.integrantes.size() > s)
                throw new TableFewSeatsException("ОШИБКА: Количество участников группы " + g.integrantes.size() + " больше количества мест на столе");
            this.seats = s;

            for (Group.Member m : g.integrantes) {
                participants.addIntegrante(m);
            }

        }

        Table(Group g) throws TableGroupHasNoMembers {
            if (g.integrantes.isEmpty())
                throw new TableGroupHasNoMembers("ОШИБКА: Группа " + g.groupName + " не имеет участников");
            this.seats = 9999;
            for (Group.Member m : g.integrantes) {
                participants.addIntegrante(m);
            }
        }

        public void setSeats(int seats) {
            this.seats = seats;
        }

        void emotion(String s, Group p) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            participants.getClass().getMethod("emotion", String.class, Group.class).invoke(participants, s, p); // reflection API                        me puede estar chupando la pija, pero mas las clases anonimas
        }

        void hear(String s, Group p) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            participants.getClass().getMethod("hear", String.class, Group.class).invoke(participants, s, p); // reflection API                           me puede estar chupando la pija, pero mas las clases anonimas
        }

        @Override
        public String toString() {
            return this.getClass() + " {" + "seats = '" + this.seats + "'}";
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != this.getClass()) {
                return false;
            }
            Table comp = (Table) obj;
            return this.seats == comp.seats;

        }

        @Override
        public int hashCode() {
            return 7 * this.seats;
        }

    }

    class TableNegativeSeatsException extends Exception {
        public TableNegativeSeatsException(String msg) {
            super(msg);
        }
    }

    class TableFewSeatsException extends Exception {
        public TableFewSeatsException(String msg) {
            super(msg);
        }
    }

    class TableGroupHasNoMembers extends RuntimeException {
        public TableGroupHasNoMembers(String msg) {
            super(msg);
        }
    }

    @Override
    public String toString() {
        return this.getClass() + " {" + "owner = '" + this.owner.getName() + '\'' + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Cabinet comp = (Cabinet) obj;
        return owner.equals(comp.owner);

    }

    @Override
    public int hashCode() {
        int result = 7;
        if (owner != null) {
            result = 13 * result + owner.hashCode();
        }
        return result;
    }


}
