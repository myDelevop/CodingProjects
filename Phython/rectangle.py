class Rectangle:

    def __init__(self, x, y, width, height):
        self.x = x
        self.y = y
        self.width = width
        self.height = height

    @staticmethod
    def intersect_rectangle(r1, r2):
        if not Rectangle.is_intersect(r1, r2):
            return Rectangle(0, 0, -1, -1)

        return Rectangle(max(r1.x, r2.x),
                         max(r1.y, r2.y),
                         min(r1.x + r1.width, r2.x + r2.width) - max(r1.x, r2.x),
                         min(r1.y + r1.height, r2.y + r2.height) - max(r1.y, r2.y))

    @staticmethod
    def is_intersect(r1, r2):
        return r1.x <= r2.x + r2.width and r1.x + r1.width >= r2.x \
               and r1.y <= r2.y + r2.height and r1.y + r1.height >= r2.y

    def __str__(self):
        s = "Rectangle: X = " + str(self.x) + " Y = " + str(self.y) + " W: " \
            + str(self.width) + " H: " + str(self.height)
        return s
