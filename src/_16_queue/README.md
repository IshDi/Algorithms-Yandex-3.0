# 16. ������� � ������� �� ������
```
����������� �������	1 �������
����������� ������	64Mb
����	����������� ���� ��� input.txt
�����	����������� ����� ��� output.txt
```
��������� ������������ ����������� ���������� ������ queue ��� ����� �����. �������� ���������, ���������� �������� ������� � ������������ ������ �������, ���������� ��� ��������� ����� ������.

��������� ��������� ������������������ ������ � � ����������� �� ������� ��������� �� ��� ���� ��������. ����� ���������� ������ ������� ��������� ������ ������� ���� �������.

��������� ������� ��� ���������:
**push n**
�������� � ������� ����� n (�������� n �������� ����� �������). ��������� ������ ������� ok.

**pop**
������� �� ������� ������ �������. ��������� ������ ������� ��� ��������.

**front**
��������� ������ ������� �������� ������� ��������, �� ������ ��� �� �������.

**size**
��������� ������ ������� ���������� ��������� � �������.

**clear**
��������� ������ �������� ������� � ������� ok.

**exit**
��������� ������ ������� bye � ��������� ������.

����� ����������� �������� front � pop ��������� ������ ���������, ���������� �� � ������� ���� �� ���� �������. ���� �� ������� ������ ����������� �������� front ��� pop, � ��� ���� ������� �����, �� ��������� ������ ������ ��������� �������� ������� ������ error.

## ������ �����
�������� ������� ���������� ��������, �� ����� �� ������

## ������ ������
��������� ������� �������� ������ �������, �� ������ ��������� �� ������

## ������ 1
### ����
```
push 1
front
exit
```
### �����
```
ok
1
bye
```
## ������ 2
### ����
```
size
push 1
size
push 2
size
push 3
size
exit
```
### �����
```
0
ok
1
ok
2
ok
3
bye
```

## ������ 3
### ����
```
push 3
push 14
size
clear
push 1
front
push 2
front
pop
size
pop
size
exit
```
### �����
```
ok
ok
2
ok
ok
1
ok
1
1
1
2
0
bye
```