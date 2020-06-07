from django.db import models


class bookNumber(models.Model):
    isbn = models.CharField(max_length=10,blank=True)

class book(models.Model):
    title = models.CharField(max_length=36)
    number = models.OneToOneField(bookNumber,null=True,blank=True,on_delete=models.CASCADE)
    def __str__(self):
        return self.title
class char(models.Model):
    name = models.CharField(max_length=30)
    book = models.ForeignKey(book,on_delete=models.CASCADE,related_name='char')
class author(models.Model):
    name = models.CharField(max_length=30)
    book = models.ManyToManyField(book,related_name='author')
