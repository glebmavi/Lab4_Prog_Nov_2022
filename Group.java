import ru.glebmavi.lab3.Senior;
import java.util.ArrayList;

public class Group {

    protected String groupName;
    ArrayList<Member> integrantes;

    Group() {
        this.groupName = "Безымянный";
        this.integrantes = new ArrayList<Member>();
    }

    Group(String groupName) {
        this.groupName = groupName;
        this.integrantes = new ArrayList<Member>();
    }

    //inner static class
    static class Member extends Senior {
        protected String emotion;
        protected ArrayList<String> heard;

        Member(){
            super();
            this.emotion = "Без эмоций";
            this.heard = new ArrayList<String>();
        }
        Member(String name) {
            super(name);
            this.emotion = "Без эмоций";
            this.heard = new ArrayList<String>();
        }


        public void setEmotion(String emotion) {
            this.emotion = emotion;
        }

        public void Hear(String s) {
            this.heard.add(s);
        }

        public String getHeard() {
            if (heard == null || heard.isEmpty()) {
                return "";
            }
            String ret = "";
            for (String h : heard) {
                ret = ret + "; " + h;
            }
            return ret;
        }

        @Override
        public String toString() {
            return this.getClass() + " {" + "name = '" + name + '\'' + ", como = " + this.getComoTitles() + ", emotion = " + emotion +", heard = " + this.getHeard() +'}';
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != this.getClass()) {
                return false;
            }
            Member comp = (Member) obj;
            return name.equals(comp.name) && como.equals(comp.como) && emotion.equals(comp.emotion);

        }

        @Override
        public int hashCode() {
            int result = 7;
            if (name != null) {
                result = 13 * result + name.hashCode();
            }
            if (como != null) {
                result = 13 * result + como.hashCode();
            }
            if (emotion != null) {
                result = 13 * result + emotion.hashCode();
            }
            return result;
        }

    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void addIntegrante(Member m) {
        this.integrantes.add(m);
    }

    public String getMemberNames() {
        if (integrantes == null || integrantes.isEmpty()) {
            return "В этой группе нет никого";
        }
        String ret = "";
        for (Senior s : integrantes) {
            ret = ret + " " + s.getName();
        }
        return ret;
    }

    @Override
    public String toString() {
        return this.getClass() + " {" + "groupName = '" + groupName + '\'' + ", integrantes = " + this.getMemberNames() + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Group comp = (Group) obj;
        return groupName.equals(comp.groupName) && integrantes.equals(comp.integrantes);

    }

    @Override
    public int hashCode() {
        int result = 7;
        if (groupName != null) {
            result = 13 * result + groupName.hashCode();
        }
        if (integrantes != null) {
            result = 13 * result + integrantes.hashCode();
        }
        return result;
    }
}
