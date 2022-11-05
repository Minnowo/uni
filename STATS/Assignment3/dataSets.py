import math

class dataSets:

    class point:

        def __str__(self):
            return f"({self.x}, {self.y})"

        def __init__(self, x, y):
            self.x = x
            self.y = y

    def __init__(self, sx = 0, sxx = 0, sy = 0, syy = 0, sxy = 0, median = 0, q1 = 0, q3 = 0, n = 0):
        self.sx = sx
        self.sxx = sxx
        self.sy = sy
        self.syy = syy
        self.sxy = sxy
        self.n = n

        self.median = median
        self.q1 = q1
        self.q3 = q3

    data = []

    # returns true if point is added, false otherwise
    def addPointXY(self, x, y):
        self.data.append(self.point(x,y))
        self.calcData()
        return True
        
    def addPoint(self, p:point):
        if not isinstance(p, dataSets.point):
            return False
        self.data.append(p)
        self.calcData()
        return True

    def calcData(self):
        self.sx = 0
        self.sxx = 0
        self.sy = 0
        self.syy = 0
        self.sxy = 0
        for i in self.data:
            self.sx += i.x
            self.sxx += i.x * i.x
            self.sy += i.y
            self.syy += i.y * i.y
            self.sxy += i.x * i.y
        self.n = len(self.data)

        self.sxx -= (self.sx * self.sx) / self.n
        self.syy -= (self.sy * self.sy) / self.n
        self.sxy -= (self.sx * self.sy) / self.n

    def getPearsonCoefficient(self):
        return self.sxy / (math.sqrt(self.sxx) * math.sqrt(self.syy))
    def getDeterminationCoefficient(self):
        return math.pow(self.getPearsonCoefficient(), 2)

    def getIntercept(self):
        return self.sy / self.n - self.getSlope() * (self.sx / self.n)

    def getSlope(self):
        return self.sxy / self.sxx

    def approximate(self, x):
        return self.getIntercept() + self.getSlope() * x

    def getResiduals(self):
        residuals = []
        for i in self.data:
            residuals.append(self.point(i.x, i.y - self.approximate(i.x)))
        return residuals

    def sortDataX(self):
        for i in range(1, self.n):
            if not isinstance(self.data[i], self.point):
                print("frick")
                continue
            x = self.data[i].x
            j = i - 1
            while j >= 0 and x < self.data[j].x:
                self.data[j + 1] = self.data[j]
                j -= 1
            self.data[j + 1].x = x
        return
    def sortDataY(self):
        for i in range(1, self.n):
            
            x = self.data[i].y
            j = i - 1
            while j >= 0 and x < self.data[j].y:
                self.data[j + 1] = self.data[j]
                j -= 1
            self.data[j + 1].y = x
        return

    # [1,2,3,4,5,6,7,8]
    # [1,2,3,4,5]
    def calcMedianX(self):
        self.sortDataX()
        if self.n % 2 == 0:
            i = self.n // 2
            self.median = (self.data[i - 1] + self.data[i]) / 2
            
            if (self.n - i) % 2 == 0:
                pass
            else:
                self.q1 = self.data[i // 2]
                self.q3 = self.n - 1 - (i // 2)
            return
        
        self.median = self.data[self.n // 2]