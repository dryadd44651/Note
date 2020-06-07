# from django.shortcuts import render
# from django.http import HttpResponse
# from django.views import View

from .models import book
from rest_framework import viewsets
from .serializers import BookSerrializer
from rest_framework.authentication import TokenAuthentication


class BookViewSet(viewsets.ModelViewSet):
    serializer_class = BookSerrializer
    queryset = book.objects.all()
    authentication_classes = (TokenAuthentication,)
# class another(View):

#     books = book.objects.all()
#     output = f"we have {len(books)} in DB"
#     def get(self,request):
#         return HttpResponse(self.output)

# def first(request):
#     books = book.objects.all()
#     #return HttpResponse('first view')
#     return render(request,'first_temp.html',{'books':books})
