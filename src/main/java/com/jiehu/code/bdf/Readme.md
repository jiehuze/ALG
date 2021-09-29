

## bfs

```` java
int n = 10, m = 10;                   //地图宽高
void BFS()
{
    queue que;              //用队列来保存路口
    int graph[n][m];          //地图
    int px[] = {-1, 0, 1, 0};   //移动方向的数组
    int py[] = {0, -1, 0, 1};
    que.push(起点入队);      //将起点入队
    while (!que.empty()) {    //只要队列不为空
        auto temp = que.pop();          //得到队列中的元素
        for (int i = 0; i != 4; ++i) {
            if(//可以走) {
                //标记当前格子
                //将当前状态入队列，等待下次提取
            }
        }
    } 
}
````

## LinkedList
````
增
public boolean add(E e)，链表末尾添加元素，返回是否成功；
public void add(int index, E element)，向指定位置插入元素；
public boolean addAll(Collection<? extends E> c)，将一个集合的所有元素添加到链表后面，返回是否成功；
public boolean addAll(int index, Collection<? extends E> c)，将一个集合的所有元素添加到链表的指定位置后面，返回是否成功；
public void addFirst(E e)，添加到第一个元素；
public void addLast(E e)，添加到最后一个元素；
public boolean offer(E e)，向链表末尾添加元素，返回是否成功；
public boolean offerFirst(E e)，头部插入元素，返回是否成功；
public boolean offerLast(E e)，尾部插入元素，返回是否成功；

删
public void clear()，清空链表；
public E removeFirst()，删除并返回第一个元素；
public E removeLast()，删除并返回最后一个元素；
public boolean remove(Object o)，删除某一元素，返回是否成功；
public E remove(int index)，删除指定位置的元素；
public E poll()，删除并返回第一个元素；
public E remove()，删除并返回第一个元素；

查
public boolean contains(Object o)，判断是否含有某一元素；
public E get(int index)，返回指定位置的元素；
public E getFirst(), 返回第一个元素；
public E getLast()，返回最后一个元素；
public int indexOf(Object o)，查找指定元素从前往后第一次出现的索引；
public int lastIndexOf(Object o)，查找指定元素最后一次出现的索引；
public E peek()，返回第一个元素；
public E element()，返回第一个元素；
public E peekFirst()，返回头部元素；
public E peekLast()，返回尾部元素；

改
public E set(int index, E element)，设置指定位置的元素；

其他
public Object clone()，克隆该列表；
public Iterator<E> descendingIterator()，返回倒序迭代器；
public int size()，返回链表元素个数；
public ListIterator<E> listIterator(int index)，返回从指定位置开始到末尾的迭代器；
public Object[] toArray()，返回一个由链表元素组成的数组；
public <T> T[] toArray(T[] a)，返回一个由链表元素转换类型而成的数组；

````


# 总结
对于这两个搜索方法，其实我们是可以轻松的看出来，他们有许多差异与许多相同点的。

##1.数据结构上的运用

DFS用递归的形式，用到了栈结构，先进后出。

BFS选取状态用队列的形式，先进先出。

##2.复杂度

DFS的复杂度与BFS的复杂度大体一致，不同之处在于遍历的方式与对于问题的解决出发点不同，DFS适合目标明确，而BFS适合大范围的寻找。

##3.思想

思想上来说这两种方法都是穷竭列举所有的情况。