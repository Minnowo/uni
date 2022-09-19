

def get_first_digit_bad(number):

    return int(str(number)[0])


class StemPlot():

    def __init__(self, raw_data, *, stem_unit = None, leaf_unit = None, leaf_category = None) -> None:

        self.raw_data = sorted(float(i) for i in raw_data)

        if stem_unit is None and leaf_unit is None:

            raise Exception("must give leaf or stem unit")

        if stem_unit is None: self.stem_unit = leaf_unit * 10
        else                : self.stem_unit = stem_unit

        if leaf_unit is None: self.leaf_unit = stem_unit / 10
        else                : self.leaf_unit = leaf_unit

        if leaf_category is None: self.leaf_category = 1
        else                    : self.leaf_category = leaf_category

        self.increment = self.stem_unit /  self.leaf_category
        self.__set_inc()

    def __set_inc(self):

        self._inc = int(str(self.increment)[0])

        if self._inc == 1:
            self._inc = 10

    def set_stem_unit(self, stem):

        self.stem_unit = stem 
        self.leaf_unit = stem / 10
        self.increment = self.stem_unit /  self.leaf_category
        self.__set_inc()

    def set_leaf_unit(self, leaf):

        self.leaf_unit = leaf
        self.stem_unit = leaf * 10
        self.increment = self.stem_unit /  self.leaf_category
        self.__set_inc()

    def set_leaf_category(self, category):

        self.leaf_category = category
        self.increment = self.stem_unit /  self.leaf_category
        self.__set_inc()

    def get_plot(self):

        plot = {}
        
        for i in self.raw_data:

            stem = int(i / self.stem_unit)

            leaf = get_first_digit_bad(int(i - (stem * self.stem_unit)))

            if stem not in plot:
                
                plot[stem] = []

            plot[stem].append(leaf)

        data = { }
        
        for key, i in plot.items():

            if key not in data:

                data[key] = []

            [data[key].append([]) for _ in range(self.leaf_category)]

            for leaf in i:

                index = 0

                while leaf >= ((index + 1) * self._inc):
                    
                    index += 1

                data[key][index].append(leaf)

        for key, value in data.items():

            for i in value:

                i.sort()

        return data 

    def print_data(self):

        print("="*32)
        print(f"SU   {self.stem_unit}, LU {self.leaf_unit}")
        print(f"LCPS {self.leaf_category}, INC {self.increment}")
        print("="*32)

        data = self.get_plot()
        sum = 0
        for key, value in data.items():

            for leafs in value:
                
                _ = " ".join(str(i) for i in leafs) 

                sum += len(leafs)

                print(f"{str(len(leafs)).zfill(2)}      {key} | {_}  ")

        print(f"leaf items : {sum}")
        print(f"data length: {len(self.raw_data)}")

def main():
    
    RAW_1 = [125.25,127.5,131.5,133.25,133.5,135.75,136.25,137.25,139.25,140.25,148.0,148.5,148.75,151.25,152.75,154.0,154.25,158.25,159.25,160.25,160.75,162.75,164.25,168.0,173.25,176.0,179.0,179.75,180.5,181.0,181.5,182.0,183.75,184.25,184.75,186.25,187.75,191.0,191.75,195.75,196.75,198.0,198.25,200.5,201.25,202.25,202.5,203.0,205.0,205.25,209.25,210.25,211.75,212.0,216.0,217.0,218.5,247.25,262.75,303.15]

    # 1 a
    StemPlot(RAW_1, stem_unit=10, leaf_category=1).print_data()

    print('='*64)

    # 1 b
    StemPlot(RAW_1, leaf_unit=10, leaf_category=5).print_data()
    


if __name__ == "__main__":
    main()

