RESULT:
*** Status  : ${result.status}
<#if result.duration??>
  * Duration: ${result.duration} ms
</#if>
<#if result.errorMessage??>
  * Error   : ${result.errorMessage}
  ****
${result.error!}
******
</#if>