import java.util.ArrayList;

public class MemberInfo {
    private String name;
    private int gradYear;
    private boolean hasGoodStanding;

    public static void main(String[] args) {
        ArrayList<MemberInfo> param = new ArrayList<MemberInfo>();
        param.add(new MemberInfo("Smith, Jane", 2019, false));
        param.add(new MemberInfo("Fox, Steve", 2018, true));
        param.add(new MemberInfo("Xin, Michael", 2017, false));
        param.add(new MemberInfo("Garcia, Maria", 2020, true));
        ClubMembers members = new ClubMembers(param);
        members.showMembers();
        System.out.println();
        String[] nameList = {"Bojack, Horseman", "Lenny, Turtletaub"};
        members.addMembers(nameList, 2025);
        members.showMembers();
        System.out.println();
        for(MemberInfo member : members.removeMembers(2018)) {
            System.out.println(member.getName() + " - " + member.getGradYear() + " - " + member.inGoodStanding());
        }
        System.out.println();
        members.showMembers();
    }   

    public MemberInfo(String name, int gradYear, boolean hasGoodStanding) {
        this.name = name;
        this.gradYear = gradYear;
        this.hasGoodStanding = hasGoodStanding;
    }

    public String getName() {
        return name;
    }

    public int getGradYear() {
        return gradYear;
    }

    public boolean inGoodStanding() {
        return hasGoodStanding;
    }
}

class ClubMembers {
    private ArrayList<MemberInfo> memberList;

    public ClubMembers(ArrayList<MemberInfo> list) {
        memberList = list;
    }

    public void addMembers(String[] names, int gradYear) {
        for(String name : names) {
            MemberInfo member = new MemberInfo(name, gradYear, true);
            memberList.add(member);
        }
    }

    public ArrayList<MemberInfo> removeMembers(int year) {
        ArrayList<MemberInfo> output = new ArrayList<MemberInfo>();
        for(int i = memberList.size() - 1; i >= 0; i--) {
            MemberInfo member = memberList.get(i);
            if(member.getGradYear() <= year) {
                memberList.remove(member);
                if(member.inGoodStanding()) {
                    output.add(member);
                }
            }
        }
        return output;
    }

    public void showMembers() {
        for(MemberInfo member : memberList) {
            System.out.println(member.getName() + " - " + member.getGradYear() + " - " + member.inGoodStanding());
        }
    }
}