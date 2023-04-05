class User: 
    def __init__(self,first_name, last_name, email, age, is_rewards_member, gold_card_points):
        self.first_name = first_name
        self.last_name= last_name
        self.email= email
        self.age= age
        self.is_rewards_member = False
        self.gold_card_points = 0
        
    def display_info(self):
        print(f"First Name: {self.first_name}")
        print(f"Last Name: {self.last_name}")
        print(f" Email: {self.email}")
        print(f"Age: {self.age}")
        print(f" Rewards Member?: {self.is_rewards_member}")
        print(f" Gold Card Points?: {self.gold_card_points}")

    def enroll(self):
        self.is_rewards_member = True 
        self.gold_card_points = 200 
        if self.is_rewards_member : 
            print("User already a member.")
            return (False)
    
    def spend_points(self, amount):
        if self.gold_card_points < amount:
            return ("Insufficient Points.")

        
        self.gold_card_points -= amount



    

my_user = User ("Anthony","Kim","anthonykim92@gmail.com","26",False,0)
print(my_user.first_name)
print(my_user.last_name)
print(my_user.email)
print(my_user.age)
print(my_user.is_rewards_member)
print(my_user.gold_card_points)

my_user.display_info().enroll().display_info().spend_points(50).display_info()
