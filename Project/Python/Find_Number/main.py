import random

print("지금부터 숫자게임을 시작하겠습니다. (1-100)")

choose_num = random.randint(1, 100)
print(choose_num)

playing = True

while playing:
  ret_str = input("Choose number : ")
  if ret_str.isdigit():
    
    ret_num = int(ret_str)
    if (choose_num < ret_num):
      print("Lower")
    elif (choose_num > ret_num):
      print("Higher")
    else:
      print("Find!!!")
      playing = False
      
  else:
    print("Please choose only number.")