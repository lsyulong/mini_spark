package com.yulong.data;

public class MyLinkedList<E> extends AbstedList<E> {
    private Node first;

    private static class Node<E> { //内部节点构造类
        Node next;
        E element;

        public Node(Node next, E element) {
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
        for (int i = 0; i < index; i++) {
            x = x.next;
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
        if (index == 0) {
            first = new Node(first, element);
        } else {
            checkPositionIndex(index);
            Node<E> pre = node(index - 1);
            Node next = pre.next;
            pre.next = new Node<E>(next, element);
        }
        size++;
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
        Node<E> oldNode = first;
        if (index == 0) {
            first = first.next;
        } else {
            Node<E> pre = node(index - 1);
            oldNode = pre.next;
            pre.next = oldNode.next;
        }
        size--;
        return oldNode.element;
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
