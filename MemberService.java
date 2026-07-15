/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication138;

/**
 *
 * @author YAHOO COMPUTER
 */
import java.util.ArrayList;

public class MemberService {

    private Library library;

    public MemberService(Library library) {
        this.library = library;
    }

    // Add Member
    public boolean addMember(Member member) {

        for (Member m : library.getMembers()) {
            if (m.getMemberId().equalsIgnoreCase(member.getMemberId())) {
                return false; // Member already exists
            }
        }

        library.getMembers().add(member);
        return true;
    }

    // Remove Member
    public boolean removeMember(String id) {

        for (Member m : library.getMembers()) {

            if (m.getMemberId().equalsIgnoreCase(id)) {
                library.getMembers().remove(m);
                return true;
            }
        }

        return false;
    }

    // Search by ID
    public Member searchById(String id) {

        for (Member m : library.getMembers()) {

            if (m.getMemberId().equalsIgnoreCase(id)) {
                return m;
            }
        }

        return null;
    }

    // Search by Name
    public ArrayList<Member> searchByName(String name) {

        ArrayList<Member> result = new ArrayList<>();

        for (Member m : library.getMembers()) {

            if (m.getFullName().toLowerCase().contains(name.toLowerCase())) {
                result.add(m);
            }
        }

        return result;
    }

    // Display Members
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
