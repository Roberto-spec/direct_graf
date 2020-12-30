
public  class Main{
    // Программа для тестирования
    //В этом графе я использовал список а не матрицу смежности, что разництца с задание
    public static void main(String args[])
        {

            // Создаем граф
            Graph g = new Graph(6);
            g.addEdge(5, 2);
            g.addEdge(5, 0);
            g.addEdge(4, 0);
            g.addEdge(4, 1);
            g.addEdge(2, 3);
            g.addEdge(3, 1);

            System.out.println("Following is a Topological " +
            "sort of the given graph");
             g.topologicalSort();


        }

}