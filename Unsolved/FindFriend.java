import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class FindFriend {
    public static void main(String[] args) {
        FindFriend ff = new FindFriend();
    }

    public FindFriend() {
        Person a = new Person("a");
        Person b1 = new Person("b1");
        Person b2 = new Person("b2");
        Person c = new Person("c");
        Person d1 = new Person("d1");
        Person d2 = new Person("d2");
        Person d3 = new Person("d3");
        Person e = new Person("e");

        a.addFriend(b1);
        a.addFriend(b2);
        b2.addFriend(b1);
        b2.addFriend(c);
        c.addFriend(d1);
        c.addFriend(d3);
        c.addFriend(d2);
        d1.addFriend(d3);
        d3.addFriend(e);

        // Find a to e;
        shortestPath(a, e);
    }

    public void shortestPath(Person a, Person b) {
        Deque<Person> history = new LinkedList<Person>();
        search(a,b,history);
    }

    public void search(Person curr, Person find, Deque history) {
        if(curr != find) {
            Deque<Person> hist = new LinkedList<Person>();
            while(history.size() > 0) {
                hist.addFirst((  (Person)history.removeLast() ));
            }
            for(Person next: curr.getFriends()){
                if(!next.getVisited()){
                    next.setVisited(true);
                    search(next, find, hist);
                }
            }
        }
        while(history.size() > 0) {
            System.out.println( (  (Person)history.removeLast() ).getId()  );
        }
    }

    public class Person {
        ArrayList<Person> friends = new ArrayList<Person>();
        String id;
        public Boolean visited = false;
        public Person(String id) {
            this.id = id;
        }

        public void setVisited(Boolean visited) {
            this.visited = visited;
        }

        public Boolean getVisited(){
            return visited;
        }

        public String getId() {
            return id;
        }

        public ArrayList<Person> getFriends() {
            return friends;
        }

        public void addFriend(Person p) {
            if(friends.contains(p))
                return;
            friends.add(p);
            p.addFriend(this);
        }
    }
}
