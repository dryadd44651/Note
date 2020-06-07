from django.contrib import admin
from .models import book, bookNumber, char, author

# Register your models here.
#admin.site.register(book)
@admin.register(book)
class bookAdmin(admin.ModelAdmin):
    #fields = ['title']
    list_display = ['title']
    list_filter = ['title']
    search_fields = ['title']
admin.site.register(bookNumber)
admin.site.register(char)
admin.site.register(author)