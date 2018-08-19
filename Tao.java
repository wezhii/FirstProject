package Zuihou;
import java.util.Scanner;
//吃货联盟订餐系统/需求分析
//(1)我要订餐(2)查看餐袋(3)签收订单(4)删除订单(5)我要点赞(6)退出系统
public class Tao {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		//设定初始界面
		System.out.println("欢迎使用吃货联盟订餐系统");
		//设定一些初始变量
		//相关数组定义
		int num=0;//定义第n个餐数
		String[] names=new String[4];			names[0]="李明";//用户名变量
		String[] disnames=new String[4];		disnames[0]="鱼香肉丝";
		int[] fens=new int[4];					fens[0]=1;//份数变量
		int[] times=new int[4];					times[0]=12;//时间变量
		String[] adds=new String[4];			adds[0]="山西省";//地址变量
		double[] sumPrice=new double[4];		sumPrice[0]=22.0;
		String[] condition=new String[4];  		condition[0]="已完成";//状态信息
		int[] dians=new int[4];					dians[0]=1;					//定义点赞数数组
		String[] canmings=new String[]{"红烧带鱼","鱼香肉丝","时令鲜蔬","酸辣肥肠"}; //餐名变量   
		double[] prices=new double[]{20.0,22.0,18.0,22.0};//单价按量
		int discharge;							//定义送餐费
		int dian;								//定义点赞数变量
		int xuhao;//定义序号变量
		int flag=1;//定义一个变量执行循环;先执行循环一次，然后在每个大case后对flag输入赋值，使之继续循环;
		do{
			System.out.println("************************");
			System.out.println("1、我要订餐");
			System.out.println("2、查看餐袋");
			System.out.println("3、签收订单");
			System.out.println("4、删除订单");
			System.out.println("5、我要点赞");
			System.out.println("6、退出系统");
			System.out.println("************************");
			System.out.print("请选择您要进行的服务：");
			xuhao=input.nextInt();//定义一个序号变量，令用户输入选择服务
		switch(xuhao){
		case 1:	System.out.println("****我要订餐****");
				boolean pan=false;//定义变量使之确定餐袋是否有剩余
				for(int i=0;i<names.length;i++){
					if(names[i]==null){
						pan=true;
						num=i;//表示之后添加餐袋的位置
						break;
					}
				}
				if(!pan) {System.out.println("对不起,餐袋没有剩余！");break;}
				System.out.println("序号\t"+"菜名\t"+"单价");
				//打印所有菜单
				for(int i=0;i<names.length;i++){
					System.out.println((i+1)+"\t"+canmings[i]+"\t"+prices[i]);
				}
				//选择所需的餐品序号
				System.out.print("请选择您要点的菜品餐号：");
				int canxu=input.nextInt();
				while(canxu<1||canxu>4){
						System.out.print("您的输入有误！应输入1到4的整数，请重新输入：");
						canxu=input.nextInt();}
				System.out.print("请选择您要点的份数：");
				int fenshu=input.nextInt();
				System.out.print("请输入订餐人姓名:");
				String name=input.next();
				System.out.print("请输入送餐时间（必须是10点到20点间整点送餐）：");
				int time=input.nextInt();
				do{
				if(time<10||time>20){
					System.out.print("您的输入有误！应输入10到20的整数，请重新输入：");
					time=input.nextInt();}
				}while(time<10||time>20);
				System.out.print("请输入您的收货地址：");
				String add=input.next();
				System.out.println("订餐成功!");
				double Price=prices[canxu-1]*fenshu;
				discharge=Price>=60?0:6;
				double zong=Price+discharge;
				System.out.println("您定的餐是："+canmings[canxu-1]+"\t "+fenshu+"份");
				System.out.println("送餐时间是："+time+"点");
				System.out.println("餐费："+prices[canxu-1]+"元"+","+"送餐费："+discharge+"元"+"，"+"总计:"+zong+"元");
				names[num]=name;
				fens[num]=fenshu;
				disnames[num]=canmings[canxu-1];
				adds[num]=add;
				times[num]=time;
				sumPrice[num]=zong;
				condition[num]="已预订";
				System.out.print("输入0返回：");
				flag=input.nextInt();
				break;
		case 2:	System.out.println("****查看餐袋****");
				System.out.println("序号\t"+"订餐人\t"+"餐品信息\t\t"+""+"送餐时间\t"+"送餐地址\t\t"+"总金额\t"+"订单状态");
				for(int j=0;j<=num;j++){
				System.out.println(+(j+1)+"\t"+names[j]+"\t"+disnames[j]+" "+fens[j]+"份\t"+""+times[j]+"\t"+adds[j]+"\t\t"+sumPrice[j]+"\t"+condition[j]);
				}
				System.out.print("输入0返回：");
				flag=input.nextInt();
				break;
		case 3:	System.out.println("****签收订单****");
				System.out.println("现有餐袋为：");
				System.out.println("序号\t"+"订餐人\t"+"餐品信息\t\t"+""+"送餐时间\t"+"送餐地址\t\t"+"总金额\t"+"订单状态");
				for(int j=0;j<=num;j++){
				System.out.println(+(j+1)+"\t"+names[j]+"\t"+disnames[j]+" "+fens[j]+"份\t"+""+times[j]+"\t"+adds[j]+"\t\t"+sumPrice[j]+"\t"+condition[j]);
				}
				System.out.print("请选择您要签收的订单：");
				int xu=input.nextInt();
				//输入要签收的订单
				if(condition[xu-1]=="已完成"||(xu-1)<0||(xu-1)>num) {System.out.print("您所选的订单有误，请再次选择！");
				xu=input.nextInt();}
				System.out.println("订单已完成，当前所有餐袋为：");
				condition[xu-1]="已完成";
				System.out.println("序号\t"+"订餐人\t"+"餐品信息\t\t"+""+"送餐时间\t"+"送餐地址\t\t"+"总金额\t"+"订单状态");
				for(int j=0;j<=num;j++){
				System.out.println(+(j+1)+"\t"+names[j]+"\t"+disnames[j]+" "+fens[j]+"份\t"+""+times[j]+"\t"+adds[j]+"\t\t"+sumPrice[j]+"\t"+condition[j]);
				}
				System.out.print("输入0返回：");
				flag=input.nextInt();
				break;
		case 4:	System.out.println("****删除订单****");
				System.out.println("现有餐袋为：");
				System.out.println("序号\t"+"订餐人\t"+"餐品信息\t\t"+""+"送餐时间\t"+"送餐地址\t"+"总金额\t"+"订单状态");
				for(int j=0;j<=num;j++){
					System.out.println(+(j+1)+"\t"+names[j]+"\t"+disnames[j]+" "+fens[j]+"份\t"+""+times[j]+"\t"+adds[j]+"\t"+sumPrice[j]+"\t"+condition[j]);
					}
				System.out.print("请输入要删除的订单号");
				int shan=input.nextInt();
				if((shan-1)<0||(shan-1)>num||condition[shan-1]=="已预订")	{System.out.print("您所选的订单有误，请再次选择:");
				shan=input.nextInt();}
				System.out.println("现有餐袋为：");
				System.out.println("序号\t"+"订餐人\t"+"餐品信息\t\t"+""+"送餐时间\t"+"送餐地址\t"+"总金额\t"+"订单状态");
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
					System.out.println(+(j+1)+"\t"+names[j]+"\t"+disnames[j]+" "+fens[j]+"份\t"+""+times[j]+"\t"+adds[j]+"\t"+sumPrice[j]+"\t"+condition[j]);
					}
				System.out.print("输入0返回：");
				flag=input.nextInt();
				break;
		case 5:	System.out.println("****我要点赞****");
				System.out.println("现有餐袋的点赞情况为：");
				for(int i=0;i<=num;i++){
					System.out.println(+(i+1)+"\t"+names[i]+"\t"+disnames[i]+" "+fens[i]+"份\t"+""+times[i]+"\t"+adds[i]+"\t"+sumPrice[i]+"\t"+condition[i]+"\t点赞数为\t"+dians[i]);
				}			
				System.out.println("请输入您要点赞的订单：");
				dian=input.nextInt();
				while(dian<0||dian>num+1){
					System.out.println("您输入的序号有误，请重新输入：");
					dian=input.nextInt();
					}
				dians[dian-1]=dians[dian-1]+1;
				System.out.println("现有餐袋的点赞情况为：");
				for(int i=0;i<=num;i++){
					System.out.println(+(i+1)+"\t"+names[i]+"\t"+disnames[i]+" "+fens[i]+"份\t"+""+times[i]+"\t"+adds[i]+"\t"+sumPrice[i]+"\t"+condition[i]+"\t点赞数为\t"+dians[i]);
				}			
				System.out.print("输入0返回：");
				flag=input.nextInt();
				break;
		case 6:	flag=1;break;
		}
		}while(flag==0);
		if(flag!=0) System.out.println("欢迎下次光临！");
		input.close();
	}
}
