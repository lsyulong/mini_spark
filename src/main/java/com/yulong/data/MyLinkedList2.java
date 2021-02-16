package com.yulong.data;

public class MyLinkedList2<E> extends AbstedList<E> {
    private Node first;
    private Node last;

    private static class Node<E> { //内部节点构造类
        Node<E> pre;
        Node<E> next;
        E element;

        public Node(Node pre, Node next, E element) {
            this.pre = pre;
            this.next = next;
            this.element = element;
        }
    }

    /**
     * 获取对应索引位置的元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        checkElementIndex(index);
        return node(index).element;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException(": Index: " + index + ", Size: " + size);
        }
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private Node<E> node(int index) {
        Node x = first;
        if (index > size >> 1) { //靠近尾
            x = last;
            for (int i = size - 1; i > index; index--) {
                x = x.pre;
            }
        } else {  //靠近头
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        }
        return x;
    }

    /**
     * 修改对应索引的值
     *
     * @param index
     * @param element
     * @return
     */
    public E set(int index, E element) {
        checkElementIndex(index);
        Node<E> node = node(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    /**
     * 指定位置添加元素
     *
     * @param index
     * @param element
     */
    public void add(int index, E element) {
        checkPositionIndex(index);
        if (index == size) { //没有元素、添加到末尾
            linkedLast(element);
        } else {
            linkedBefore(element, node(index));
        }
        size++;
    }

    private void linkedLast(E element) {
        Node l = last;
        Node newNode = new Node(l, null, element);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
    }

    private void linkedBefore(E element, Node node) {
        Node<E> pre = node.pre;
        Node<E> newNode = new Node<E>(pre, node, element);
        node.pre = newNode;
        if (pre.next == null) {
            first = newNode;
        } else {
            pre.next = newNode;
        }
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException(": Index: " + index + ", Size: " + size);
        }
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    /**
     * 删除某个元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        checkElementIndex(index);
        Node<E> node = node(index);
        Node<E> pre = node.pre; //获取到前一个节点
        Node<E> next = node.next;//获取到后一个节点

        if (pre == null) {  //index == 0  删除的是头节点
            first = next;
            next.pre = null;
        } else {
            pre.next = next;
        }
        if (next == null) { //index == size 删除的是最后一个元素
            last = pre;
        } else {
            next.pre = pre;
        }
        size--;
        return node.element;
    }

    public int indexOf(E element) {
        Node x = first;
        int index = 0;
        if (element == null) { //null == null
            for (Node i = x; i != null; i = i.next) {
                if (element == i.element) {
                    return index;
                }
                index++;
            }

        } else {
            for (Node i = x; i != null; i = i.next) {
                if (element.equals(i.element)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    /**
     * 清除链表中的元素，并且将size置为0
     */
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder().append("[");
            Node x = first;
            for (Node i = x; i != null; i = i.next) {
                sb.append(i.element);
                if (i.next == null) {
                    return sb.append("]").toString();
                }
                sb.append(",");
            }
            return sb.toString();
        }
    }
}
