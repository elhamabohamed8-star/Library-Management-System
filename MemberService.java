
import java.util.ArrayList;

public class MemberService {

    private Library library;

    public MemberService(Library library) {
        this.library = library;
    }

    public boolean addMember(Member member) {

        for (Member m : library.getMembers()) {
            if (m.getMemberId().equalsIgnoreCase(member.getMemberId())) {
                return false; 
            }
        }

        library.getMembers().add(member);
        return true;
    }

    public boolean removeMember(String id) {

        for (Member m : library.getMembers()) {

            if (m.getMemberId().equalsIgnoreCase(id)) {
                library.getMembers().remove(m);
                return true;
            }
        }

        return false;
    }

    public Member searchById(String id) {

        for (Member m : library.getMembers()) {

            if (m.getMemberId().equalsIgnoreCase(id)) {
                return m;
            }
        }

        return null;
    }

    public ArrayList<Member> searchByName(String name) {

        ArrayList<Member> result = new ArrayList<>();

        for (Member m : library.getMembers()) {

            if (m.getFullName().toLowerCase().contains(name.toLowerCase())) {
                result.add(m);
            }
        }

        return result;
    }

    public void displayMembers() {

        if (library.getMembers().isEmpty()) {
            System.out.println("No members found.");
            return;
        }

        for (Member m : library.getMembers()) {
            m.displayMember();
        }
    }

    
}
