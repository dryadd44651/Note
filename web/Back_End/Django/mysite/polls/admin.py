from django.contrib import admin

from .models import Question
from .models import Choice

# Default
# admin.site.register(Question)

# Smae as Default
# class QuestionAdmin(admin.ModelAdmin):
#     fields = ['pub_date', 'question_text']
# admin.site.register(Question, QuestionAdmin)

# new order
class QuestionAdmin(admin.ModelAdmin):
    # add
    fieldsets = [
        (None,               {'fields': ['question_text']}),
        ('Date information', {'fields': ['pub_date']}),
    ]
    # show
    list_display = ('question_text', 'pub_date')
    # search
    search_fields = ['question_text']
admin.site.register(Question, QuestionAdmin)

# Register the Admin classes for Choice using the decorator
@admin.register(Choice)
class ChoiceAdmin(admin.ModelAdmin):
    pass