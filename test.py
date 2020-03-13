
# takes 4-6 minutes to run
import subprocess
i = 0
n = 270
a = ['random_input_data1.txt','random_input_data2.txt','random_input_data3.txt','random_input_data4.txt','random_input_data5.txt','random_input_data6.txt','random_input_data7.txt','random_input_data8.txt','random_input_data9.txt','random_input_data10.txt']
b = ['comparisons_outut_1.txt','comparisons_outut_2.txt','comparisons_outut_3.txt','comparisons_outut_4.txt','comparisons_outut_5.txt','comparisons_outut_6.txt','comparisons_outut_7.txt','comparisons_outut_8.txt','comparisons_outut_9.txt','comparisons_outut_10.txt',]

for i in range(10):
	p1 = subprocess.run(['shuf', '-n',str(n),'Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt',], capture_output = True,text = True)
	
	file1 = open("../scripts/part_5 simulation_data/"+a[i],"a") 
	file1.writelines(p1.stdout)
	file1.close()
	subprocess.run(['java', 'part5',"../scripts/part_5 simulation_data/"+a[i],"../scripts/part_5 simulation_data/"+b[i] ],capture_output = True)
	n = n +270

	
