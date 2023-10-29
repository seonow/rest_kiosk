 $(function(){ $('.menuCategory li').click(function(){
      var idx=$(this).index()
      
      $('.menuList >*').hide().removeClass('on')
      $('.menuList >*').eq(idx).show().addClass('on')

   })
  })