'''
Fractional Knapsack Problem
'''


class ItemValue: 
    def __init__(self, w, v, index): 
        self.w = w 
        self.v = v 
        self.ind = index 
        self.cost = v / w 
  
    def __lt__(self, other): 
        return self.cost < other.cost 


class FractionalKnapSack:
    
    @staticmethod
    def getMaxValue(w, v, W): 
        iVal = [] 
        for i in range(len(w)): 
            iVal.append(ItemValue(w[i], v[i], i)) 

        # sorting items by value 
        iVal.sort(reverse = True)
        
        valuesTaken = []
        totalValue = 0
        
        weight = 0
        for i in iVal:
            curWt = int(i.w) 
            curVal = int(i.v) 
            if weight + curWt <= W:
                weight = weight + curWt
                valuesTaken.append(curVal)
                totalValue += curVal
            else:
                fraction = (W-weight)/curWt
                totalValue += curVal * fraction
                weight = W
                valuesTaken.append(curVal*fraction)
        print("Values Taken :", valuesTaken)
        return totalValue 
  

if __name__ == "__main__": 
    w = list(map(int,input('Enter Weights: ').split()))
    v = list(map(int,input('Enter Values: ').split()))
    W = int(input('Enter Capacity: '))

    #v/w ratio has to be maximized to get maximum value with min. possible weight.
    maxValue = FractionalKnapSack.getMaxValue(w, v, W) 
    print("Maximum value in Knapsack =", maxValue) 
    
