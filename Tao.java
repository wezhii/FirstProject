package Zuihou;
import java.util.Scanner;
//�Ի����˶���ϵͳ/�������
//(1)��Ҫ����(2)�鿴�ʹ�(3)ǩ�ն���(4)ɾ������(5)��Ҫ����(6)�˳�ϵͳ
public class Tao {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		//�趨��ʼ����
		System.out.println("��ӭʹ�óԻ����˶���ϵͳ");
		//�趨һЩ��ʼ����
		//������鶨��
		int num=0;//�����n������
		String[] names=new String[4];			names[0]="����";//�û�������
		String[] disnames=new String[4];		disnames[0]="������˿";
		int[] fens=new int[4];					fens[0]=1;//��������
		int[] times=new int[4];					times[0]=12;//ʱ�����
		String[] adds=new String[4];			adds[0]="ɽ��ʡ";//��ַ����
		double[] sumPrice=new double[4];		sumPrice[0]=22.0;
		String[] condition=new String[4];  		condition[0]="�����";//״̬��Ϣ
		int[] dians=new int[4];					dians[0]=1;					//�������������
		String[] canmings=new String[]{"���մ���","������˿","ʱ������","�����ʳ�"}; //��������   
		double[] prices=new double[]{20.0,22.0,18.0,22.0};//���۰���
		int discharge;							//�����Ͳͷ�
		int dian;								//�������������
		int xuhao;//������ű���
		int flag=1;//����һ������ִ��ѭ��;��ִ��ѭ��һ�Σ�Ȼ����ÿ����case���flag���븳ֵ��ʹ֮����ѭ��;
		do{
			System.out.println("************************");
			System.out.println("1����Ҫ����");
			System.out.println("2���鿴�ʹ�");
			System.out.println("3��ǩ�ն���");
			System.out.println("4��ɾ������");
			System.out.println("5����Ҫ����");
			System.out.println("6���˳�ϵͳ");
			System.out.println("************************");
			System.out.print("��ѡ����Ҫ���еķ���");
			xuhao=input.nextInt();//����һ����ű��������û�����ѡ�����
		switch(xuhao){
		case 1:	System.out.println("****��Ҫ����****");
				boolean pan=false;//�������ʹ֮ȷ���ʹ��Ƿ���ʣ��
				for(int i=0;i<names.length;i++){
					if(names[i]==null){
						pan=true;
						num=i;//��ʾ֮����Ӳʹ���λ��
						break;
					}
				}
				if(!pan) {System.out.println("�Բ���,�ʹ�û��ʣ�࣡");break;}
				System.out.println("���\t"+"����\t"+"����");
				//��ӡ���в˵�
				for(int i=0;i<names.length;i++){
					System.out.println((i+1)+"\t"+canmings[i]+"\t"+prices[i]);
				}
				//ѡ������Ĳ�Ʒ���
				System.out.print("��ѡ����Ҫ��Ĳ�Ʒ�ͺţ�");
				int canxu=input.nextInt();
				while(canxu<1||canxu>4){
						System.out.print("������������Ӧ����1��4�����������������룺");
						canxu=input.nextInt();}
				System.out.print("��ѡ����Ҫ��ķ�����");
				int fenshu=input.nextInt();
				System.out.print("�����붩��������:");
				String name=input.next();
				System.out.print("�������Ͳ�ʱ�䣨������10�㵽20��������Ͳͣ���");
				int time=input.nextInt();
				do{
				if(time<10||time>20){
					System.out.print("������������Ӧ����10��20�����������������룺");
					time=input.nextInt();}
				}while(time<10||time>20);
				System.out.print("�����������ջ���ַ��");
				String add=input.next();
				System.out.println("���ͳɹ�!");
				double Price=prices[canxu-1]*fenshu;
				discharge=Price>=60?0:6;
				double zong=Price+discharge;
				System.out.println("�����Ĳ��ǣ�"+canmings[canxu-1]+"\t "+fenshu+"��");
				System.out.println("�Ͳ�ʱ���ǣ�"+time+"��");
				System.out.println("�ͷѣ�"+prices[canxu-1]+"Ԫ"+","+"�Ͳͷѣ�"+discharge+"Ԫ"+"��"+"�ܼ�:"+zong+"Ԫ");
				names[num]=name;
				fens[num]=fenshu;
				disnames[num]=canmings[canxu-1];
				adds[num]=add;
				times[num]=time;
				sumPrice[num]=zong;
				condition[num]="��Ԥ��";
				System.out.print("����0���أ�");
				flag=input.nextInt();
				break;
		case 2:	System.out.println("****�鿴�ʹ�****");
				System.out.println("���\t"+"������\t"+"��Ʒ��Ϣ\t\t"+""+"�Ͳ�ʱ��\t"+"�Ͳ͵�ַ\t\t"+"�ܽ��\t"+"����״̬");
				for(int j=0;j<=num;j++){
				System.out.println(+(j+1)+"\t"+names[j]+"\t"+disnames[j]+" "+fens[j]+"��\t"+""+times[j]+"\t"+adds[j]+"\t\t"+sumPrice[j]+"\t"+condition[j]);
				}
				System.out.print("����0���أ�");
				flag=input.nextInt();
				break;
		case 3:	System.out.println("****ǩ�ն���****");
				System.out.println("���вʹ�Ϊ��");
				System.out.println("���\t"+"������\t"+"��Ʒ��Ϣ\t\t"+""+"�Ͳ�ʱ��\t"+"�Ͳ͵�ַ\t\t"+"�ܽ��\t"+"����״̬");
				for(int j=0;j<=num;j++){
				System.out.println(+(j+1)+"\t"+names[j]+"\t"+disnames[j]+" "+fens[j]+"��\t"+""+times[j]+"\t"+adds[j]+"\t\t"+sumPrice[j]+"\t"+condition[j]);
				}
				System.out.print("��ѡ����Ҫǩ�յĶ�����");
				int xu=input.nextInt();
				//����Ҫǩ�յĶ���
				if(condition[xu-1]=="�����"||(xu-1)<0||(xu-1)>num) {System.out.print("����ѡ�Ķ����������ٴ�ѡ��");
				xu=input.nextInt();}
				System.out.println("��������ɣ���ǰ���вʹ�Ϊ��");
				condition[xu-1]="�����";
				System.out.println("���\t"+"������\t"+"��Ʒ��Ϣ\t\t"+""+"�Ͳ�ʱ��\t"+"�Ͳ͵�ַ\t\t"+"�ܽ��\t"+"����״̬");
				for(int j=0;j<=num;j++){
				System.out.println(+(j+1)+"\t"+names[j]+"\t"+disnames[j]+" "+fens[j]+"��\t"+""+times[j]+"\t"+adds[j]+"\t\t"+sumPrice[j]+"\t"+condition[j]);
				}
				System.out.print("����0���أ�");
				flag=input.nextInt();
				break;
		case 4:	System.out.println("****ɾ������****");
				System.out.println("���вʹ�Ϊ��");
				System.out.println("���\t"+"������\t"+"��Ʒ��Ϣ\t\t"+""+"�Ͳ�ʱ��\t"+"�Ͳ͵�ַ\t"+"�ܽ��\t"+"����״̬");
				for(int j=0;j<=num;j++){
					System.out.println(+(j+1)+"\t"+names[j]+"\t"+disnames[j]+" "+fens[j]+"��\t"+""+times[j]+"\t"+adds[j]+"\t"+sumPrice[j]+"\t"+condition[j]);
					}
				System.out.print("������Ҫɾ���Ķ�����");
				int shan=input.nextInt();
				if((shan-1)<0||(shan-1)>num||condition[shan-1]=="��Ԥ��")	{System.out.print("����ѡ�Ķ����������ٴ�ѡ��:");
				shan=input.nextInt();}
				System.out.println("���вʹ�Ϊ��");
				System.out.println("���\t"+"������\t"+"��Ʒ��Ϣ\t\t"+""+"�Ͳ�ʱ��\t"+"�Ͳ͵�ַ\t"+"�ܽ��\t"+"����״̬");
				for(shan=shan-1;shan<num;shan++){
					names[shan]=names[shan+1];
					disnames[shan]=disnames[shan+1];
					fens[shan]=fens[shan+1];
					adds[shan]=adds[shan+1];
					times[shan]=times[shan+1];
					condition[shan]=condition[shan+1];
					sumPrice[shan]=sumPrice[shan+1];
				}
				num=num-1;
				for(int j=0;j<=num;j++){
					System.out.println(+(j+1)+"\t"+names[j]+"\t"+disnames[j]+" "+fens[j]+"��\t"+""+times[j]+"\t"+adds[j]+"\t"+sumPrice[j]+"\t"+condition[j]);
					}
				System.out.print("����0���أ�");
				flag=input.nextInt();
				break;
		case 5:	System.out.println("****��Ҫ����****");
				System.out.println("���вʹ��ĵ������Ϊ��");
				for(int i=0;i<=num;i++){
					System.out.println(+(i+1)+"\t"+names[i]+"\t"+disnames[i]+" "+fens[i]+"��\t"+""+times[i]+"\t"+adds[i]+"\t"+sumPrice[i]+"\t"+condition[i]+"\t������Ϊ\t"+dians[i]);
				}			
				System.out.println("��������Ҫ���޵Ķ�����");
				dian=input.nextInt();
				while(dian<0||dian>num+1){
					System.out.println("�����������������������룺");
					dian=input.nextInt();
					}
				dians[dian-1]=dians[dian-1]+1;
				System.out.println("���вʹ��ĵ������Ϊ��");
				for(int i=0;i<=num;i++){
					System.out.println(+(i+1)+"\t"+names[i]+"\t"+disnames[i]+" "+fens[i]+"��\t"+""+times[i]+"\t"+adds[i]+"\t"+sumPrice[i]+"\t"+condition[i]+"\t������Ϊ\t"+dians[i]);
				}			
				System.out.print("����0���أ�");
				flag=input.nextInt();
				break;
		case 6:	flag=1;break;
		}
		}while(flag==0);
		if(flag!=0) System.out.println("��ӭ�´ι��٣�");
		input.close();
	}
}
