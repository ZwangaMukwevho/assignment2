import subprocess

# Output textfile names
out = ["BST_printAreas.txt","AVL_printAreas.txt"]

## Test cases for BST
# Correct test cases
a = [["1","18","00"],["5","24","10"],["8","3", "06"]]

# Incorrect test cases
b = [["-1", "21","00"],["5", "35", "01"],["8","3","25"]]

file1 = open("../scripts/part_1_to_4_tests/"+out[0],"a")

for i in range(3):
	p1 = subprocess.run(['java', 'LSBSTApp',a[i][0],a[i][1],a[i][2], ],capture_output = True,text = True)
	file1.writelines(p1.stdout)

for i in range(3):
	p2 = subprocess.run(['java', 'LSBSTApp',b[i][0],b[i][1],b[i][2], ],capture_output = True,text = True)
	file1.writelines(p2.stdout)
file1.close()


## Test cases for AVL
# Correct test cases
a = [["3","26","08"],["6","1","12"],["7","27", "02"]]

# Incorrect test cases
b = [["-2", "21","00"],["5", "40", "01"],["8","3","30"]]

file2 = open("../scripts/part_1_to_4_tests/"+out[1],"a")
for i in range(3):
	p3 = subprocess.run(['java', 'AVLApp',a[i][0],a[i][1],a[i][2], ],capture_output = True,text = True)
	file2.writelines(p3.stdout)

for i in range(3):
	p4 = subprocess.run(['java', 'AVLApp',b[i][0],b[i][1],b[i][2], ],capture_output = True,text = True)
	file2.writelines(p4.stdout)
file2.close()



