#����: �ܹ� �ٱ�(JumpGame)
- N*M ũ���� ���ڿ� 1���� 9������ ������ �� ������ �ִ�. �̶� ������ ������ �������� ���� �� ĭ���� �����ؼ� �������� �� ������ �Ʒ� ĭ 0�� �����ϴ� ���̴�. �̶� �� ĭ�� ���� �ִ� ���ڸ�ŭ �Ʒ����̳� ���������� �̵��� �� ������, �߰��� ������ ������ ����� �� �ȴ�.
- �������� �־��� �� ���������� ���� 0���� �����ϴ� ����� �����ϴ��� Ȯ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

###�Է�
- ������ ù° �ٿ��� �׽�Ʈ ���̽� ������ ��Ÿ���� �ڿ��� T�� �־�����,
- ���� ���ʷ� T���� �׽�Ʈ ���̽��� �־�����.
- ������ �׽�Ʈ ���̽� ù ��° �ٿ��� �������� ũ�� N, M�� �־�����. (1<=N, M<=20)
- ���� �ٺ��ʹ� N���� ���� �־�����, �� �ٸ��� M���� ���ڰ� �־�����, �� ���ڴ� 0~9 �� �ϳ��̴�.
- ���� '0'�� ������ �ǹ��Ѵ�.

###���
- �� �׽�Ʈ ���̽��� ���� ������� ǥ��������� ����Ͽ��� �ϸ�,
- �� �׽�Ʈ ���̽����� ö �ٿ� "Case #T"�� ����Ͽ��� �Ѵ�. �̶� T�� �׽�Ʈ ���̽��� ��ȣ�̴�.
- �� ���� �ٿ��� �������� �����ϴ� ����� �����ϴ� ��� "True", ����� �������� �ʴ� ��� "False"�� ����Ѵ�.

###�Է� ��
- 2
- 7 7
- 2 5 1 6 1 4 1
- 6 1 1 2 2 9 3
- 7 2 3 2 1 3 1
- 1 1 3 1 7 1 2
- 4 1 2 3 4 1 2
- 3 3 1 2 3 4 1
- 1 5 2 9 4 7 0
- 7 7
- 2 5 1 6 1 4 1
- 6 1 1 2 2 9 3
- 7 2 3 2 1 3 1
- 1 1 3 1 7 1 2
- 4 1 2 3 4 1 3
- 3 3 1 2 3 4 1
- 1 5 2 9 4 7 0

###��� ��
Case #1
True
Case #2
False

##Ǯ��
###�⺻ Ǯ��
- ���� ��ȹ���� �̿��� ����ȭ ������ �ذ��Ѵ�.
- �켱 �� ���� ��ĭ���� �����ϴ� ��� ��θ� �ϳ��� ����� ���� ������ ĭ�� ������ �� �ִ��� �˻��ϴ� ���� Ž�� �˰������� �����.
- ��� �Լ��� ������ ���� �����.
- jump(y, x)�� (y, x)�������� �� ������ ĭ���� ������ �� �ִ��� ���θ� ��ȯ�Ѵ�.
- jump(y, x)�� �ѹ� ȣ��� ������ ���⿡�� �Ʒ������� ����, ���������� ������ �����Ѵ�. �������� (y,x) ��ġ�� �ִ� ���� jumpSize�� �ϸ�, �� ��� �Ʒ������� �� ��� ������ ĭ�� ������ �� �ִ����� jump(y+jumpSize, x), ���������� �� ��� jump(y, x+jumpSize)�� ǥ���� �� �ִ�. �� �� ��� �� �ϳ��� �����ص� ��������� jump(y, x)�� ������ ���� ��������� ǥ���� �� �ִ�.
- jump(y, x) = jump(y+jumpSize, x) || jump(y, x+jumpSize)
- ���� ���� ���� Ž���� �޸������̼��� �����Ѵ�.

###���� ��ȹ�� ������
- �밳 ���� ��ȹ�� �˰������� ������ ������ ���� �� �ܰ�� �̷������.
- 1. �־��� ������ ���� Ž���� �̿��� �ذ��Ѵ�.
- 2. �ߺ��� �κ� ������ �� ���� ����ϵ��� �޸������̼��� �����Ѵ�.

##����
- inputData()�� �Է� ���� �о����, printResult()�� ����� ����Ѵ�.
- initialize_cache()�� �޸������̼ǿ� ���Ǵ� cache�� �ʱ�ȭ�Ѵ�.
- �޸������̼��� ������ ���Ǹ� ���� jump()�� boolean�� �ƴ� int�� �����Ѵ�.
- jump(y, x)�� �������� ��� ��� 0, ������ ĭ�� ������ ��� 1�� ��ȯ�ϰ�, �� ���� ��� �Ʒ������� �� ���� ���������� �� ��츦 ���� �õ��Ѵ�.