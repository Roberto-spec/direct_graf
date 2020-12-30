import java.io.*;
import java.util.*;

//  Этот класс представляет ориентированный граф с использованием списка смежности
class Graph
{
    private int V;   // Количество вершин
    private LinkedList<Integer> adj[]; // Список смежности

    // Конструктор
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    // Функция для добавления ребра в граф
    void addEdge(int v,int w) { adj[v].add(w); }

    // Рекурсивная функция, используемая topologicalSort
    void topologicalSortUtil(int v, boolean visited[],
                             Stack stack)
    {
        //  Помечаем текущий узел как посещенный
        visited[v] = true;
        Integer i;

        // Рекурсивно вызываем функцию для всех смежных вершин
        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext())
        {
            i = it.next();
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }

        // Добавляем текущую вершину в стек с результатом
        stack.push(new Integer(v));
    }

    // Функция для поиска топологической сортировки.
    // Рекурсивно использует topologicalSortUtil()
    void topologicalSort()
    {
        Stack stack = new Stack();

        // Помечаем все вершины как непосещенные
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        // Вызываем рекурсивную вспомогательную функцию
        // для поиска топологической сортировки для каждой вершины
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);

        // Выводим содержимое стека
        while (stack.empty()==false)
            System.out.print(stack.pop() + " ");
    }


}