RESULT:
*** Status  : ${result.status}
  * Duration: ${result.duration} ms
<#if result.errorMessage??>
  * Error   : ${result.errorMessage}
  ****
${result.error!}
******
</#if>